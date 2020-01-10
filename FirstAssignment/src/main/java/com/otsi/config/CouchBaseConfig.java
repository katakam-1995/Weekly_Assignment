package com.otsi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.CouchbaseConfigurer;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.cluster.ClusterInfo;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;

@Configuration
public class CouchBaseConfig implements CouchbaseConfigurer {

	@Override
	public CouchbaseEnvironment couchbaseEnvironment() throws Exception {
		return DefaultCouchbaseEnvironment.create();
	}

	@Override
	public Cluster couchbaseCluster() throws Exception {
		CouchbaseCluster cluster = CouchbaseCluster.create("10.80.2.6");
		cluster.authenticate("Administrator", "password");
		return cluster;
	}

	@Override
	public ClusterInfo couchbaseClusterInfo() throws Exception {
		return couchbaseCluster().clusterManager().info();
	}

	@Override
	public Bucket couchbaseClient() throws Exception {

		return ((Cluster) couchbaseCluster()).openBucket("Demo");
	}

}
