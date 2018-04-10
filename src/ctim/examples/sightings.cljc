(ns ctim.examples.sightings
  (:require [ctim.schemas.common :as c]))

(def sighting-maximal
  {:id "http://ex.tld/ctia/sighting/sighting-eb965192-9f85-4bc8-baa2-0766f9f63db3"
   :external_ids ["http://ex.tld/ctia/sighting/sighting-123"
                  "http://ex.tld/ctia/sighting/sighting-456"]
   :external_references
   [{:source_name "source"
     :external_id "T1067"
     :url "https://ex.tld/wiki/T1067"
     :hashes ["#section1"]
     :description "Description text"}]
   :timestamp #inst "2016-02-11T00:40:48.212-00:00"
   :observed_time {:start_time #inst "2016-02-11T00:40:48.212-00:00"
                   :end_time #inst "2016-02-11T00:40:48.212-00:00"}
   :description "a sighting"
   :short_description "short desc"
   :tlp "amber"
   :source "source"
   :source_uri "http://example.com"
   :sensor "endpoint.sensor"
   :targets [{:type "endpoint"
              :os "Windows 95"
              :observed_time {:start_time #inst "2016-02-11T00:40:48.212-00:00"
                              :end_time #inst "2016-02-11T00:40:48.212-00:00"}
              :observables [{:type "hostname" :value "Demo_Cta"}
                            {:type "amp_computer_guid" :value "68e94bf7-e239-4821-90d6-b7eaa0233443"}
                            {:type "ip" :value "100.213.110.122"}
                            {:type "ip" :value "136.184.130.98"}
                            {:type "mac_address" :value "85:28:cb:6a:21:41"}]
              :properties_data_tables "http://example.com/ctia/data-table/data-table-6e279a0d-6788-4cdf-957f-4e4b73823d6c"}]
   :confidence "High"
   :type "sighting"
   :schema_version c/ctim-schema-version
   :count 1
   :revision 1
   :internal true
   :severity "Info"
   :resolution "detected"
   :language "language"
   :title "title"
   :observables [{:type "ipv6" :value "blah"}]
   :relations [{:origin "origin"
                :origin_uri "http://example.com"
                :relation "Used_By"
                :relation_info {:foo "bar"}
                :source {:type "ipv6" :value "foo"}
                :related {:type "ipv6" :value "bar"}}]})

(def sighting-minimal
  {:id "http://ex.tld/ctia/sighting/sighting-eb965192-9f85-4bc8-baa2-0766f9f63db3"
   :observed_time {:start_time #inst "2016-02-11T00:40:48.212-00:00"
                   :end_time #inst "2016-02-11T00:40:48.212-00:00"}
   :confidence "High"
   :type "sighting"
   :schema_version c/ctim-schema-version
   :count 1})

(def new-sighting-maximal
  sighting-maximal)

(def new-sighting-minimal
  {:observed_time {:start_time #inst "2016-02-11T00:40:48.212-00:00"
                   :end_time #inst "2016-02-11T00:40:48.212-00:00"}})

(def stored-sighting-maximal
  (into sighting-maximal
        {:owner "foouser"
         :groups ["bar"]
         :created #inst "2016-02-11T00:40:48.212-00:00"
         :modified #inst "2016-02-11T00:40:48.212-00:00"}))

(def stored-sighting-minimal
  (into sighting-minimal
        {:owner "foouser"
         :groups ["bar"]
         :created #inst "2016-02-11T00:40:48.212-00:00"
         :modified #inst "2016-02-11T00:40:48.212-00:00"}))
