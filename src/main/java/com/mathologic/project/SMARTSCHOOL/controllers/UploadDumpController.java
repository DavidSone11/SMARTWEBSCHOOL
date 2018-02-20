/**
 * 
 */
package com.mathologic.project.SMARTSCHOOL.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import com.mathologic.project.SMARTSCHOOL.exception.smartwebException;
import com.mathologic.project.SMARTSCHOOL.helpers.FileHandlingHelper;
import com.mathologic.project.SMARTSCHOOL.mongo.entity.UserUploadDump;
import com.mathologic.project.SMARTSCHOOL.mongo.repositories.UserUploadDumpRepository;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author Administrator
 *
 */

@Controller("UploadDumpController")
@RequestMapping("/api/v1/uploadDump")

public class UploadDumpController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private final Logger uploadDumpLogger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserUploadDumpRepository userUploadDumpRepository;
	


	public UploadDumpController() {
		uploadDumpLogger.trace("doStuff needed more information - {}");
		uploadDumpLogger.debug("doStuff needed to debug - {}");
		uploadDumpLogger.info("doStuff took input - {}");
		uploadDumpLogger.warn("doStuff needed to warn - {}");
		uploadDumpLogger.error("doStuff encountered an error with value - {}");
	}

	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public @ResponseBody String getUserTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		return dateFormat.format(date);
	}
	

	@RequestMapping(value = "/findByAllParams", method = RequestMethod.GET)
	public @ResponseBody
	Page<UserUploadDump> findByAllParams(
			@RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "sortByName", required = false, defaultValue = "uploaderName") String sortByName,
			@RequestParam(value = "sortOrder", required = false, defaultValue = "DESC") String sortOrder,
			@RequestParam(value = "uploaderName", required = false, defaultValue = "") String uploaderName
			
			){
		
	
		//return iUploadDumpService.findByAllParams(limit, page, sortbyName, sortOrder,uploaderName);
		//return userUploadDumpRepository.findByAllParams(uploaderName,new PageRequest(page-1, limit, Direction.valueOf(sortOrder), sortByName));
		return null;
}
	

	@RequestMapping(value = "/trainDumpUpload", method = RequestMethod.POST, consumes = "multipart/form-data")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = smartwebException.class)
	public @ResponseBody String UploadTrain(
			@RequestParam(value = "UploaderName", required = false, defaultValue = "Santosh") String uploaderName,
			@RequestParam("uploadFile") MultipartFile[] fileTrainDetails, RedirectAttributes redirectAttributes)
			throws smartwebException {
		{

			FileOutputStream fo;
			Path currentRelativePath = Paths.get("");
			String s = currentRelativePath.toAbsolutePath().toString();

			createUploadedDir(s + "/uploads");
			
			if (fileTrainDetails.length == 0) {
				throw new smartwebException("No file was been selected !!!!");
			}

			for (MultipartFile file : fileTrainDetails) {
				if (!file.getOriginalFilename().contains(".csv")) {
					throw new smartwebException("The File format is not in CSV!!!!!!!");
				}

				if (!file.isEmpty()) {
					try {
						String tempFileName = s + "/uploads/" +getCurrentDateTime()+"_"+file.getOriginalFilename();
						fo = new FileOutputStream(tempFileName);
						loadToDB(file.getBytes(),file);
						fo.write(file.getBytes());
						fo.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				} else {
					throw new smartwebException("The File is Empty in CSV!!!!!!!");
				}

			}

			return "File dump to db successfully!!!!!";

		}

	}

	
	public String getCurrentDateTime() {

        Date date = new Date() ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
        return dateFormat.format(date);
	}
	public boolean createUploadedDir(String name) {
        boolean result = false;
		File theDir = new File(name);
		if (!theDir.exists()) {
			 result = false;

			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				
			}
			
		}
		return result;
	}
	
	public String loadToDB(byte[] bs,MultipartFile file) {

		UserUploadDump userUploadDump = null;
		
		

		if (userUploadDump == null) {
		
			userUploadDump = new UserUploadDump();
			userUploadDump.setUploaderName("santosh");
			userUploadDump.setFileSizeInByte(file.getSize());
			userUploadDump.setTotalfileSize(FileHandlingHelper.getStringSizeLengthFile(file.getSize()));
			userUploadDump.setUploadedDateTime(LocalDateTime.now());
			userUploadDump.setUploadStatus(true);
			userUploadDump.setFileName(file.getOriginalFilename());
			userUploadDump.setFileOriginalName(file.getName());
			userUploadDump.setFileType(FileHandlingHelper.getExtension(file.getOriginalFilename()));
			userUploadDump.setUploadContent(bs);
			userUploadDumpRepository.save(userUploadDump);
		}
        uploadDumpLogger.info("File has been loaded to DB...........");
        return "File has been loaded to DB";

	}
}
