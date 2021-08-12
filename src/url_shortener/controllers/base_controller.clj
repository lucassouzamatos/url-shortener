(ns url-shortener.controllers.base_controller)

(defn success 
  [data]
  {:status  200
    :headers {"Content-Type" "application/json"}
    :body data})
