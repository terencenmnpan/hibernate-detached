# hibernate-detached
Demo Project to show issue encountered by JBEAP-25196/HHH-16586 - 
When merging a persisted entity with a null Version, Hibernate treats entity as transient instead of throwing an Exception
