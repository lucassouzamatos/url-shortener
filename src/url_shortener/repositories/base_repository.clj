(ns url-shortener.repositories.base_repository
    (:require 
      [url-shortener.states.connection :refer [conn]]
      [clojure.string :as str]
      [clojure.java.jdbc :as jdbc]))

(defn insert!
    [values]
    (jdbc/insert! conn :url values))
  
(defn- prepare-statement
  [table key]
  (-> 
    (str/replace "select * from url where key = ?" #"key" key)
    (str/replace ,,, #"table" table)))
  
(defn get-document-by!
  [table key value]
  (let [statement (prepare-statement table key)
        query [statement value]
        rows  (jdbc/query conn query)]
    (if (empty? rows)
      nil
      (first rows))))