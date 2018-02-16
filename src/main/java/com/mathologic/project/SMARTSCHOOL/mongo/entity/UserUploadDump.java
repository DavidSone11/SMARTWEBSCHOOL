/**
 * 
 */
package com.mathologic.project.SMARTSCHOOL.mongo.entity;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Administrator
 *
 */

@Document(collection = "UserUploadDump")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserUploadDump implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Indexed(direction = IndexDirection.ASCENDING)
	private String id;

	//@NotNull
	@Field(value = "uploadername")
	@Size(max = 100)
	private String uploaderName;

	//@NotNull
	@Field(value = "uploadstatus")
	private boolean uploadStatus = Boolean.FALSE;


	@Field(value = "filenames")
	@Size(max = 100)
	private String fileName;


	@Field(value = "fileTypes")
	@Size(max = 100)
	private String fileType;

	@Field(value = "fileOriginalNames")
	@Size(max = 100)
	private String fileOriginalName;

	@Field(value = "fileSizeInBytes")
	@Size(max = 100)
	private Long fileSizeInByte;


	@Field(value = "totalfileSizes")
	@Size(max = 100)
	private String totalfileSize;


	@Field(value = "uploadedDateTimes")
	private LocalDateTime uploadedDateTime = LocalDateTime.now();


	@Field(value = "markDelete")
	private Boolean markDelete =Boolean.FALSE;



	public LocalDateTime getUploadedDateTime() {
		return uploadedDateTime;
	}

	public void setUploadedDateTime(LocalDateTime uploadedDateTime) {
		this.uploadedDateTime = uploadedDateTime;
	}

	@Field(value = "UploadContent")
	private byte[] UploadContent;

	public UserUploadDump() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the uploaderName
	 */
	public String getUploaderName() {
		return uploaderName;
	}

	/**
	 * @param uploaderName
	 *            the uploaderName to set
	 */
	public void setUploaderName(String uploaderName) {
		this.uploaderName = uploaderName;
	}

	/**
	 * @return the markDelete
	 */
	public Boolean getMarkDelete() {
		return markDelete;
	}

	/**
	 * @param markDelete
	 *            the markDelete to set
	 */
	public void setMarkDelete(Boolean markDelete) {
		this.markDelete = markDelete;
	}

	/**
	 * @return the uploadContent
	 */
	public byte[] getUploadContent() {
		return UploadContent;
	}

	/**
	 * @param uploadContent
	 *            the uploadContent to set
	 */
	public void setUploadContent(byte[] uploadContent) {
		UploadContent = uploadContent;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType
	 *            the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return the totalfileSize
	 */
	public String getTotalfileSize() {
		return totalfileSize;
	}

	/**
	 * @param totalfileSize
	 *            the totalfileSize to set
	 */
	public void setTotalfileSize(String totalfileSize) {
		this.totalfileSize = totalfileSize;
	}


	/**
	 * @return the uploadStatus
	 */
	public boolean isUploadStatus() {
		return uploadStatus;
	}

	/**
	 * @param uploadStatus the uploadStatus to set
	 */
	public void setUploadStatus(boolean uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

	/**
	 * @return the fileSizeInByte
	 */
	public Long getFileSizeInByte() {
		return fileSizeInByte;
	}

	/**
	 * @param fileSizeInByte the fileSizeInByte to set
	 */
	public void setFileSizeInByte(Long fileSizeInByte) {
		this.fileSizeInByte = fileSizeInByte;
	}

	/**
	 * @return the fileOriginalName
	 */
	public String getFileOriginalName() {
		return fileOriginalName;
	}

	/**
	 * @param fileOriginalName the fileOriginalName to set
	 */
	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName;
	}



}
