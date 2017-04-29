dataSource {
	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	username = "root"
	dialect = org.hibernate.dialect.MySQL5InnoDBDialect
	properties {
		maxActive = 151
		minEvictableIdleTimeMillis=28800
		timeBetweenEvictionRunsMillis=28800
		numTestsPerEvictionRun=3
		testOnBorrow=true
		testWhileIdle=true
		testOnReturn=true
		validationQuery="SELECT 1"
		jdbcInterceptors="ConnectionState"
	}
}

hibernate {
    cache.use_second_level_cache = false
    cache.use_query_cache = false
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory'
}

environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost:3306/evento"
			password = "qaz12345"
        }
    }
    test {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost:3306/evento"
			password = "qaz12345"
        }
    }
    production {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost:3306/evento"
			password = "D1sC@2O17"
        }
    }
}