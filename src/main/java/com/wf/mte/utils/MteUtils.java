package com.wf.mte.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public abstract class MteUtils {

	public static <D, T> List<T> mapperObject(List<D> elements, ModelMapper modelMapper) {
		List<T> ret = new ArrayList<>();
		for (D c : elements) {
			T dto = modelMapper.map(c,Object.class);
			ret.add(dto);
		}
		return ret;
	}
}
