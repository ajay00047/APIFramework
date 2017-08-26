package com.pola.api.delegate;

import com.pola.api.beans.BaseRequestBean;

public interface Processor {

	public DataBean process(BaseRequestBean bean) throws Exception;
}
