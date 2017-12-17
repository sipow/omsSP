package com.ubs.simonpowers.oms.datasource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ubs.simonpowers.oms.domain.MyIdentifiable;
public abstract class InMemoryRepository<T extends MyIdentifiable> {

	@Autowired
	private IdGenerator idGenerator;
	private List<T> elements = Collections.synchronizedList(new ArrayList<>());
	
	public T create(T element) {
		elements.add(element);
		element.setId(idGenerator.getNextId());
		return element;

	}

	public boolean delete(Long id) {
		return elements.removeIf(element -> element.getId().equals(id));
	}

	public List<T> findAll() {
		return elements;
	}

	public Optional<T> findById(Long id) {
		return elements.stream().filter(e -> e.getId().equals(id)).findFirst();
	}

	public int getCount() {
		return elements.size();
	}

	public void clear() {
		elements.clear();
	}
}