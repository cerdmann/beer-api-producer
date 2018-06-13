package beer.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  description("""
    Ensure that a candidate for beer who is 21 years 
    is allowed to purchase a beer
  """)
  request {
    method POST()
    url "/check"
    body(age:$(regex('2[1-9]|[3-9][0-9]|[1-9]\\d{2,2}')))
    headers {
      contentType(applicationJson())
    }
  }
  response {
    status 200
    body("""
      { "status" : "OK" }
    """)
   headers {
     contentType(applicationJson())
   }
  }
}