(ns url-shortener.infra.migrations
  (:require 
    [url-shortener.states.connection :refer [conn]]
    [clojure.java.jdbc :as jdbc]))

(defn startup
  []
  (jdbc/db-do-commands conn
    (jdbc/create-table-ddl
      "IF NOT EXISTS url"
      [[:original "varchar(255)"]
       [:hash "varchar(255)"]]))
  (println "Migrations executed"))
