package com.networkdesign.industrialnetworksystem.pojo;


public class AllFile {
    private String fileName;
    private String filePath;
    private String fileType;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }


    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "AllFile{" +
                "fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
