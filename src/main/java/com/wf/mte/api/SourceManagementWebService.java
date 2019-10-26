package com.wf.mte.api;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wf.mte.dto.SourceDto;
import com.wf.mte.services.ISourceService;

@Controller
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class SourceManagementWebService {

	@Autowired
	ISourceService sourceService;

	@GetMapping("/api/sources")
	@ResponseBody
	public ResponseEntity<List<SourceDto>> getAllSource() {
		return ResponseEntity.ok(sourceService.findAll());
	}

	@GetMapping("/api/sources/{id}")
	@ResponseBody
	public ResponseEntity getSource(@PathVariable Long id) {
		return ResponseEntity.ok(sourceService.findSourceById(id));
	}

	@PostMapping("/api/sources/add")
	@ResponseBody
	public ResponseEntity<Void> addSource(@Valid @RequestBody SourceDto sourceDto) {
		SourceDto result = sourceService.addSource(sourceDto);

		if (result == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/api/sources/update")
	@ResponseBody
	public ResponseEntity<SourceDto> updateSource(@RequestBody SourceDto sourceDto) {
		SourceDto result = sourceService.updateSource(sourceDto);
		if (result == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result).toUri();

		return ResponseEntity.created(location).build();
	}

}
