package com.example.designmode.qidianclass.structural.portfolio;

/**
 * @author julu
 * @date 2022/9/6 23:31
 */
public class File extends FileSystemNode{
    public File(String path) {
        super(path);
    }

    @Override
    protected int countNumOfFiles() {
        return 1;
    }

    @Override
    protected long countSizeOfFiles() {
        java.io.File file = new java.io.File(path);
        if (!file.exists()){
            return 0;
        }
        return file.length();
    }
}
