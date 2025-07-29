package com.cafeMoeum.repository.jpa

import com.cafeMoeum.entities.Cafe
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CafeJpaRepository: JpaRepository<Cafe, UUID>