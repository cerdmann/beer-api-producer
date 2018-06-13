import org.springframework.cloud.contract.spec.Contract

Contract.make {
  description("""
    Sends a positive verification message when someone is eligible to buy beer
  """)

  label "accepted_verification"
  input {
    triggeredBy("clientIsOldEnough()")
  }
  outputMessage {
    sentTo "verifications"
    body(eligible: true)
    headers{
        header ("contentType", applicationJsonUtf8())
    }
  }
}
