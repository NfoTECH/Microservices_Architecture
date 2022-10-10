package com.fortunate.service;

import com.fortunate.payload.request.NotificationRequest;

public interface NotificationService {
    void sendNotification(NotificationRequest notificationRequest);
}
