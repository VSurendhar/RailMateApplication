# RailMate Application 🚆🎫

A user-friendly Android application for booking and canceling train tickets, built using Jetpack Compose. The app allows users to select their train seats and navigate through different screens for booking and canceling tickets.

## Features 📱✨
- **Book Ticket**: Users can book a train ticket by selecting their seat and confirming the booking.
- **Cancel Ticket**: Users can cancel their ticket by entering the PNR number.
- **Reservation Seats**: Displays available seats for reservation.
- **RAC Seats**: Displays available RAC seats for booking.

## Screens 📸

### 1. **Main Screen**
The main screen shows the options to book or cancel the ticket. 

<img src="https://github.com/user-attachments/assets/0eae30f7-bc0a-4ca9-9bc6-ce331c1f9a43" width="40%" height="40%" />

### 2. **Book/Cancel Ticket Screen**
This screen is displayed when users choose to book or cancel their ticket. 

#### Before selecting a seat:
<img src="https://github.com/user-attachments/assets/83aa0834-e1ac-4097-b94d-40c2f4e7a2b6" width="40%" height="40%" />

#### After selecting a seat:
<img src="https://github.com/user-attachments/assets/2a84f85a-1cd0-43d9-9e7e-aabed6f7d473" width="40%" height="40%" />


## Seat Color Representation 🎨
- **⬜ Gray Color Seat**: Indicates that the seat is **occupied** and cannot be selected.
- **🟩 Green Color Seat**: Represents a **selected seat**.
- **🟨 Sandal Color Seat**: Indicates **open seats** that are available for booking or cancellation.


## Tech Stack 🛠️
- **Jetpack Compose**: For building the UI using declarative UI components.
- **Kotlin**: The primary programming language for the app.
- **Hilt**: For dependency injection.
- **Coroutines**: For managing background tasks.
- **Room Database**: For local data storage (if applicable).
- **Retrofit**: For network operations to fetch seat data and make bookings.
- **MVVM Architecture**: For better separation of concerns and testability.

## Getting Started 🚀
1. **Clone the repository**: 
   ```bash
   git clone https://github.com/yourusername/TrainTicketBookingApp.git


# Contributing 🤝

We welcome contributions! Feel free to fork the repository and submit pull requests.

## Steps to contribute:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes.
4. Submit a pull request with a clear description of the changes.
