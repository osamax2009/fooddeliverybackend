package com.codewithfk.model

import kotlinx.serialization.Serializable

@Serializable
data class RiderLocation(
    val id: String,
    val latitude: Double,
    val longitude: Double,
    val isAvailable: Boolean,
    val lastUpdated: String
)

@Serializable
data class DeliveryRequest(
    val orderId: String,
    val restaurantLocation: Location,
    val customerLocation: Location,
    val estimatedEarning: Double,
    val distance: Double,
    val status: String // PENDING, ACCEPTED, REJECTED
)

@Serializable
data class Location(
    val latitude: Double,
    val longitude: Double,
    val address: String
)

@Serializable
data class DeliveryPath(
    val currentLocation: Location,
    val nextStop: Location,
    val finalDestination: Location,
    val polyline: String, // Encoded polyline from Google Maps
    val estimatedTime: Int, // in minutes
    val deliveryPhase: DeliveryPhase
)

enum class DeliveryPhase {
    TO_RESTAURANT,    // Rider heading to restaurant
    TO_CUSTOMER      // Rider heading to customer
}

@Serializable
data class AvailableDelivery(
    val orderId: String,
    val restaurantName: String,
    val restaurantAddress: String,
    val customerAddress: String,
    val orderAmount: Double,
    val estimatedDistance: Double,
    val estimatedEarning: Double,
    val createdAt: String
)

@Serializable
data class DeliveryStatusUpdate(
    val status: String, // PICKED_UP, DELIVERED, FAILED
    val reason: String? = null
)

enum class DeliveryStatus {
    PENDING,
    ACCEPTED,
    REJECTED,
    PICKED_UP,
    DELIVERED,
    FAILED
}

@Serializable
data class RiderDelivery(
    val orderId: String,
    val status: String,
    val restaurant: RestaurantDetail,
    val customer: CustomerAddress,
    val items: List<OrderItemDetail>,
    val totalAmount: Double,
    val estimatedEarning: Double,
    val createdAt: String,
    val updatedAt: String
)

@Serializable
data class RestaurantDetail(
    val id: String,
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val imageUrl: String
)

@Serializable
data class CustomerAddress(
    val addressLine1: String,
    val addressLine2: String? = null,
    val city: String,
    val state: String? = null,
    val zipCode: String,
    val latitude: Double,
    val longitude: Double
)

@Serializable
data class OrderItemDetail(
    val id: String,
    val name: String,
    val quantity: Int,
    val price: Double
) 