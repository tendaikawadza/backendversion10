package io.getarrays.securecapita.Stores.stores;

import java.io.Serializable;

public class StoresVO implements Serializable {



    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String processName;

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("StoresVO [processName=");
        builder.append(processName);
        builder.append("]");
        return builder.toString();
    }

}
