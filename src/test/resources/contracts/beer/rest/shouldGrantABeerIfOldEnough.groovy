package contracts.beer.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  description("""
    This test ensures a correct response when a candidate is old enough

  """)
  request {
    method POST()
    url "/check"
    body(age:$(regex('[2-9][0-9]')))
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