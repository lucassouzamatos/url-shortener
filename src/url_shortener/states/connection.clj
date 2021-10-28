(ns url-shortener.states.connection
  (:require
    [mount.core :refer [defstate]]
    [clojure.java.jdbc :as jdbc]))

(def db-spec
  {:classname   "org.sqlite.JDBC"
    :subprotocol "sqlite"
    :subname     "database.db"})

(defn start []
  (let [conn (jdbc/get-connection db-spec)]
    {:connection conn}))

(defstate conn :start (start))
