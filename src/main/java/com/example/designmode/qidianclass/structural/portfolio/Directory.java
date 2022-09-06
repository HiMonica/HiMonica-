package com.example.designmode.qidianclass.structural.portfolio;

import java.util.ArrayList;
import java.util.List;

/**
 * @author julu
 * @date 2022/9/6 23:33
 */
public class Directory extends FileSystemNode{

    private List<FileSystemNode> subNodes = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    @Override
    protected int countNumOfFiles() {
        int numOfFiles = 0;
        for (FileSystemNode subNode : subNodes) {
            numOfFiles += subNode.countNumOfFiles();
        }
        return numOfFiles;
    }

    @Override
    protected long countSizeOfFiles() {
        long sizeOfFiles = 0L;
        for (FileSystemNode subNode : subNodes) {
            sizeOfFiles += subNode.countSizeOfFiles();
        }
        return sizeOfFiles;
    }

    public void setSubNodes(FileSystemNode subNode) {
        subNodes.add(subNode);
    }
}
