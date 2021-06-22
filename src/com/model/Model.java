package com.model;

import java.io.IOException;

public class Model {

    private ApiCall caller;

    public Model() throws IOException {
        caller = new ApiCall();
    }

    public void updateTraffic() {
        caller.getNewCall();
        // view.updateView(caller.getI76Avg(), caller.getI476Avg());
    }
}
