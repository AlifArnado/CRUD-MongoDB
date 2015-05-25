package com.mogoDB.java;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Main_MongoJava {
	public static void main(String[] args) {
	    MongoManager mgMongo = new MongoManager("keluarga");
	    BasicDBObject saya = new BasicDBObject();
	    
	    // tambah data
	    saya.put("nama"    , "Alif Benden Arnado");
	    saya.put("tgllahir", "13 - November - 1994");
	    saya.put("anakke"  , "1 (pertama)");
	    saya.put("hobi"    , "Mancing , Main Komputer , Makan");
	    saya.put("teman"   , "Mukti , Heri");
	    mgMongo.addDocument(saya, "saudara");
	    
	    // tampilkan data
	    ArrayList<BasicDBObject> list = mgMongo.getCollectionData("saudara");
	    System.out.println("Input Data Ke MongoDB");
	    for (BasicDBObject data : list) {
	    	 System.out.println(data.get("nama"));
	    	 System.out.println(data.get("tgllahir"));
	    	 System.out.println(data.get("anakke"));
	    	 System.out.println(data.get("hobi"));
	    	 System.out.println(data.get("teman"));
	    }
	    System.out.println("");
	    
	    
	    // update data
	    BasicDBObject kiteria = new BasicDBObject();
	    kiteria.put("nama", "Alif Benden Arnado");
	    
	    // buat ObjekBaru
	    BasicDBObject baru = new BasicDBObject();
	    baru.put("nama"    , "Arnado Benden Alif");
	    baru.put("tgllahir", "13 - November - 1994");
	    baru.put("anakke"  , "1 (pertama)");
	    baru.put("hobi", "Experiment , Baca Buku");
	    baru.put("teman"   , "Mukti , Heri");
	    mgMongo.updateDocument(kiteria, baru, "saudara");
	    
	    // tampilkan data
	    list = mgMongo.getCollectionData("saudara");
	    System.out.println("Update Data Ke MongoDB");
	    for (BasicDBObject data : list) {
	    	 System.out.println(data.get("nama"));
	    	 System.out.println(data.get("tgllahir"));
	    	 System.out.println(data.get("anakke"));
	    	 System.out.println(data.get("hobi"));
	    	 System.out.println(data.get("teman"));
	    }
	    System.out.println("");
	    
	    // menghapus data 
	    BasicDBObject hapusSaya = new BasicDBObject();
	    hapusSaya.put("anakke"  , "1 (pertama)");
	    hapusSaya.put("hobi", "Experiment , Baca Buku");
	    hapusSaya.put("teman"   , "Mukti , Heri");
	    mgMongo.removeDocument(hapusSaya, "saudara");
	    
	 // tampilkan data
	    list = mgMongo.getCollectionData("saudara");
	    System.out.println("Data Di Hapus");
	    for (BasicDBObject data : list) {
	    	 System.out.println(data.get("anakke"));
	    	 System.out.println(data.get("hobi"));
	    	 System.out.println(data.get("teman"));
	    }
	    System.out.println("");
	    
    
}
}
