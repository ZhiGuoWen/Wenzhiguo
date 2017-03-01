package com.wenzhiguo.wenzhiguo20170227;

import java.util.List;

/**
 * Created by dell on 2017/2/27.
 */

public class Bean {
    private String cname;
    private List<NodesBean> nodes;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<NodesBean> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodesBean> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "cname='" + cname + '\'' +
                ", nodes=" + nodes +
                '}';
    }
}
