package com.book.ticket.service;

public interface Sequence {
	long getNextSequenceId(String key) throws Exception;
}
