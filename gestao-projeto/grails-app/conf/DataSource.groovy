dataSource {
    pooled = true
       driverClassName = "com.mysql.jdbc.Driver"
       username = "root"
       dialect = org.hibernate.dialect.MySQL5InnoDBDialect
       properties {
          maxActive = 50
          maxIdle = 25
          minIdle = 5
          initialSize = 5
          minEvictableIdleTimeMillis = 1800000
          timeBetweenEvictionRunsMillis = 1800000
          maxWait = 10000
          ValidationQuery = 'select 1'
       }
}

hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory'
}

environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost:3306/evento"
			password = "qaz12345"
			//url = "jdbc:mysql://evento.cpvw2j1ohiub.sa-east-1.rds.amazonaws.com:3306/evento"
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
