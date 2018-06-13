package beer.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  description("""
    This test ensures a correct response when a candidate is not old enough

  """)
  request {
    method POST()
    url "/check"
    body(age:$(regex('[0-9]|[2][0]|[1][0-9]')))
    headers {
      contentType(applicationJson())
    }
  }
  response {
    status 200
    body("""
      { "status" : "NOT_OK" }
    """)
    headers {
      contentType(applicationJson())
    }
  }
}

