# Background

Demo of spring boot 3 with swagger and b3 header propagation using micrometer and open telemetry

# Run Project locally
`mvn spring-boot:run`

# B3 header format

## Incoming request headers

X-B3-TraceId: 463ac35c9f6413ad48485a3953bb6124

X-B3-SpanId: a2fb4a1d1a96d312

TraceId will then be sent to outgoing HTTP requests when using RestTemplate
