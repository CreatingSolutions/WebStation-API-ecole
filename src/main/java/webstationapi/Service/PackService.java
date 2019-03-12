package webstationapi.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webstationapi.Entity.Pack;
import webstationapi.Repository.PackRepository;

@Service
public class PackService {

	@Autowired
	private PackRepository packRepository;
	
	public List<Pack> getAllPacks() {
		return StreamSupport.stream(packRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}
	
}
