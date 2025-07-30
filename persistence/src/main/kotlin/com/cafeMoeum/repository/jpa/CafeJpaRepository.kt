package com.cafeMoeum.repository.jpa

import com.cafeMoeum.entities.Cafe
import org.springframework.data.jpa.repository.JpaRepository

interface CafeJpaRepository: JpaRepository<Cafe, String>