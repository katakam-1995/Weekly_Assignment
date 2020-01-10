package com.book.ticket.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.book.ticket.model.SequenceId;
import com.book.ticket.service.Sequence;

@Service
public class SequenceImpl implements Sequence {

	@Autowired
	private MongoOperations mongoOperation;

	@Override
	public long getNextSequenceId(String key) throws Exception {
		Query query = new Query(Criteria.where("_id").is(key));
		Update update = new Update();
		update.inc("seq", 1);
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);
		SequenceId seqId = mongoOperation.findAndModify(query, update, options, SequenceId.class);
		if (seqId == null) {
			throw new Exception("Unable to get sequence id for key : " + key);
		}

		return seqId.getSeq();

	}

}
