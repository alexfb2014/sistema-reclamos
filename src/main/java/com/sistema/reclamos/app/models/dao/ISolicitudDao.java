package com.sistema.reclamos.app.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sistema.reclamos.app.models.entity.Estado;
import com.sistema.reclamos.app.models.entity.Solicitud;

public interface ISolicitudDao extends PagingAndSortingRepository<Solicitud, Long>{

	
//	@Query("select s from Solicitud s join fetch s.cliente c join fetch f.detalle d join fetch s.estado"
//			+ "join fetch s.motivo m join fetch s.producto join fetch s.estadoEvalua where s.id=1 and s.estado =5")
//	Page<Solicitud> ListarSolicitudesRegistradasYDevueltas(Pageable pageable);

	Page<Solicitud> findByestadoEvaluaOrEstadoEvalua(Estado estado1, Estado estado2,Pageable pageable);
	
	Page<Solicitud> findByestadoEvalua(Estado estado1,Pageable pageable);
	
}
