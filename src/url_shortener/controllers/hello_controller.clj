(ns url-shortener.controllers.hello_controller
  (:require 
    [clojure.pprint :as pp]))

(defn hello-name [req]
  {:status  200
    :headers {"Content-Type" "text/html"}
    :body (->
          (pp/pprint req)
          (str "Hello " (:name (:params req))))})