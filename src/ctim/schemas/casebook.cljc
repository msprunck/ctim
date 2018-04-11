(ns ctim.schemas.casebook
  (:require
   [ctim.schemas.bundle :as bun]
   [ctim.schemas.common :as c]
   #?(:clj  [flanders.core :as f :refer [def-entity-type def-map-type def-eq]]
      :cljs [flanders.core :as f :refer-macros [def-entity-type def-map-type def-eq]])))

(def type-identifier "casebook")

(def-eq CasebookTypeIdentifier type-identifier)

(def casebook-desc
  "Describes a CTIM Casebook which works like a structured gist")

(def-map-type Text
  (f/required-entries
   (f/entry :type f/any-str)
   (f/entry :text f/any-str)))

(def-entity-type Casebook
  {:description casebook-desc
   :reference "#"}
  c/base-entity-entries
  c/sourcable-object-entries
  c/describable-entity-entries
  (f/required-entries
   (f/entry :type CasebookTypeIdentifier))
  (f/optional-entries
   (f/entry :observables (f/seq-of c/Observable))
   (f/entry :bundle bun/Bundle)
   (f/entry :texts (f/seq-of Text))))

(def-entity-type NewCasebook
  {:description casebook-desc
   :reference "#"}
  (:entries Casebook)
  c/base-new-entity-entries
  (f/optional-entries
   (f/entry :type CasebookTypeIdentifier)))

(def-entity-type StoredCasebook
  {:description casebook-desc
   :reference "#"}
  (:entries Casebook)
  c/base-stored-entity-entries)

(def CasebookRef
  (c/ref-for-type type-identifier))
