package net.unboxit.massrfid.model

enum class CustomerType {
    FUJI, ISUZU
}
enum class ProcessType {
    REGISTER, INBOUND, OUTBOUND, RESCAN
}
data class Job(
    var customerType: CustomerType = CustomerType.FUJI,
    var processType: ProcessType = ProcessType.REGISTER,
)
