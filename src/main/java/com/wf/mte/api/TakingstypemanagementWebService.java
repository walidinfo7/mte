package com.wf.mte.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wf.mte.dto.SourceDto;
import com.wf.mte.dto.TakingsTypeDto;
import com.wf.mte.services.ItakingsTypeSerivices;

@Controller
public class TakingstypemanagementWebService {
	@Autowired
	private ItakingsTypeSerivices takingsTypeServices;
		
	@PostMapping(path= "/api/takingstypes/add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public  ResponseEntity<TakingsTypeDto> addTakingType(@RequestBody TakingsTypeDto takingsTypeDto){
		TakingsTypeDto result = takingsTypeServices.addTakingsTypes(takingsTypeDto);
		if(result == null) {
			return ResponseEntity.noContent().build();
		}
		URI location =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result).toUri();
	    return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/api/takingstypes/{id}")
	public ResponseEntity<TakingsTypeDto> deleteTakingType(@PathVariable Long id){
		takingsTypeServices.deleteTakingsTypes(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "/api/takingstypes/{id}")
	public ResponseEntity<TakingsTypeDto> updateTakingType(@RequestBody TakingsTypeDto takingsTypeDto) {
		TakingsTypeDto takingsTypeDtoUpdated = takingsTypeServices.updateTakingType(takingsTypeDto);
		if (takingsTypeDtoUpdated == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(takingsTypeDtoUpdated).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path = "/api/takingstypes")
	public ResponseEntity<List<TakingsTypeDto>> getAllTakingTypes(){
		List<TakingsTypeDto> ret = takingsTypeServices.getAllTakingsTypes();
		return ResponseEntity.ok(ret);
	}
	
	@GetMapping(path = "/api/takingstypes/{id}")
	public ResponseEntity<TakingsTypeDto> getTakingsTypesById(@PathVariable Long id){
		return ResponseEntity.ok(takingsTypeServices.getTakingsTypeById(id));
	}
}
