package coding.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import coding.service.ImportService;

@Controller
public class ImportController {

	@Autowired
	ImportService importService;

	@RequestMapping(value = "/api/importFiles", method = RequestMethod.POST)
	public ResponseEntity<String> importMarketBudgetedSpend(@RequestBody MultipartFile file,
			@RequestBody MultipartFile file2, @RequestBody MultipartFile file3) throws Exception {
		Set<String> answer = importService.processCSV(file, file2, file3);
		return ResponseEntity.ok().body(answer.toString());
	}

}
