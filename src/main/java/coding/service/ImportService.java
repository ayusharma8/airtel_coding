package coding.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import coding.constant.Constants;

@Service
public class ImportService {

	Logger logger = LoggerFactory.getLogger(ImportService.class);
	public Set<String> processCSV(MultipartFile file, MultipartFile file2, MultipartFile file3) throws Exception {

		Map<String, Set<String>> allWordsForFile = new HashMap<>();
		logger.info("=======Starting Import========");
		try {
			logger.info("Processing first file");
			allWordsForFile.put(file.getName(), getWords(file));
			logger.info("Processing second file");
			allWordsForFile.put(file2.getName(), getWords(file2));
			logger.info("Processing third file");
			allWordsForFile.put(file3.getName(), getWords(file3));
			Set<String> answer = getCommonWordsFromFiles(allWordsForFile);
			logger.info("Answer is"+answer.toString());
			return answer;
		} catch (IOException e) {
			throw new IOException();
		}catch (RuntimeException e) {
			throw new RuntimeException();
		}catch (Exception e) {
			throw new Exception();
		}
	}

	private Set<String> getCommonWordsFromFiles(Map<String, Set<String>> allWordsForFile) {

		Set<String> betweenFirstTwo = getCommonWords(allWordsForFile.get(Constants.FILE), allWordsForFile.get(Constants.FILE_2));
		Set<String> answer = getCommonWords(betweenFirstTwo, allWordsForFile.get(Constants.FILE_3));

		return answer;
	}

	private Set<String> getCommonWords(Set<String> set, Set<String> set2) {
		Set<String> commonWords = new HashSet<>();
		for (String string : set) {
			if (set2.contains(string)) {
				commonWords.add(string);
			}
		}
		return commonWords;
	}

	private Set<String> getWords(MultipartFile file) throws IOException {
		Set<String> result = new HashSet<>();
		BufferedReader br;
		String line;
		InputStream is = file.getInputStream();
		br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			String[] words = line.split(" ");
			Set<String> oneLine = new HashSet<>();
			for (String string : words) {
				string = string.replaceAll("[^a-zA-Z0-9]", "");
				oneLine.add(string.trim().toLowerCase());
			}
			result.addAll(oneLine);
		}
		return result;
	}

}
