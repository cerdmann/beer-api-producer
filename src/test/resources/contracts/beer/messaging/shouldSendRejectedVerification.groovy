package contracts.beer.messaging

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  description("""
    Sends a negative verification message when someone is ineligible to buy beer
  """)

  label "rejected_verification"
  outputMessage {
    sentTo "verifications"
    body(eligible: false)
    headers{
      header ("contentType", applicationJsonUtf8())
    }
  }

}

