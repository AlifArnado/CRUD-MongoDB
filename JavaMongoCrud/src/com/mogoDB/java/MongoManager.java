package com.mogoDB.java;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class MongoManager {
	private String dbname;
	  private DB db;

	  public MongoManager(String dbname) {
	    this.dbname = dbname;
	    try {
	      Mongo mongo = new Mongo();
	      this.db = mongo.getDB(dbname);
	    } catch (UnknownHostException ex) {
	    } catch (MongoException ex) {
	    }
	  }

	  public void addDocument(DBObject object, String collectionName) {
	    db.getCollection(collectionName).insert(object);
	  }

	  public String getDBName() {
	    return this.dbname;
	  }

	  public ArrayList getCollectionData(String collectionName) {
	    ArrayList list = new ArrayList();
	    DBCursor cursor = db.getCollection(collectionName).find();
	    while (cursor.hasNext()) {
	       DBObject object = cursor.next();
	       list.add(object);
	    }
	    return list;
	  }

	  public void removeDocument(DBObject criteria, String collectionName) {
	    db.getCollection(collectionName).remove(criteria);
	  }

	  public void updateDocument(DBObject criteria, DBObject newObject, String collectionName) {
	    db.getCollection(collectionName).update(criteria, newObject);
	  }
}
