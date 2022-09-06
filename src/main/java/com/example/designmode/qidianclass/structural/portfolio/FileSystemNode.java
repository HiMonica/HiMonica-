package com.example.designmode.qidianclass.structural.portfolio;

/**
 * @author julu
 * @date 2022/9/6 23:28
 */
public abstract class FileSystemNode {

    protected String path;

    public FileSystemNode(String path){
        this.path = path;
    }
    
    protected abstract int countNumOfFiles();

    protected abstract long countSizeOfFiles();

    public String getPath(){
        return this.path;
    }
}
