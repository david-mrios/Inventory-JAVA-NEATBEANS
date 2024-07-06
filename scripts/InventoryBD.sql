/*
 * 
 * Project : Inventory
 * Date Created : 21/5/2023
 */

Use Master;
Go
Create database Inventory;
Go
Use Inventory;
Go



/* 
 * TABLE: Custodio 
 */

Create table Custodio
(
	inss		    INT  PRIMARY KEY ,
	nombres			VARCHAR (30)		   NOT NULL,
	apellidos		VARCHAR (30)		   NOT NULL,
	telefono		BIGINT                 NOT NULL,
	cedula			VARCHAR (20)		   NOT NULL,
	activo			INT					   NOT NULL
);

Go
IF OBJECT_ID('Custodio') IS NOT NULL
    PRINT '<<< CREATED TABLE Custodio >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE Custodio >>>'
Go

/* 
 * TABLE: usuario_c 
 */

Create table usuario_c
(
	idUsuario_c		    INT  PRIMARY KEY IDENTITY (1,1),
	contrasenia			VARCHAR (30)		   NOT NULL,
	inss				INT		    		   NOT NULL,
	FOREIGN KEY (inss) REFERENCES Custodio(inss)
);

Go
IF OBJECT_ID('usuario_c') IS NOT NULL
    PRINT '<<< CREATED TABLE usuario_c >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE usuario_c >>>'
Go

/* 
 * TABLE: Instructor 
 */

Create table Instructor
(
	noCarnet		INT  PRIMARY KEY ,
	nombres			VARCHAR (30)		   NOT NULL,
	apellidos		VARCHAR (30)		   NOT NULL,
	telefono		INT					   NOT NULL,
	cedula			VARCHAR (20)		   NOT NULL,
	activo			INT					   NOT NULL
);

Go
IF OBJECT_ID('Instructor') IS NOT NULL
    PRINT '<<< CREATED TABLE Instructor >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE Instructor >>>'
Go

/* 
 * TABLE: usuario_I 
 */

Create table usuario_I
(
	idUsuario_I		    INT  PRIMARY KEY IDENTITY (1,1),
	contrasenia			VARCHAR (30)		   NOT NULL,
	noCarnet			INT		    		   NOT NULL,
	FOREIGN KEY (noCarnet) REFERENCES Instructor(noCarnet)
);

Go
IF OBJECT_ID('usuario_I') IS NOT NULL
    PRINT '<<< CREATED TABLE usuario_I >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE usuario_I >>>'
Go


/* 
 * TABLE: Responsable 
 */

Create table Responsable
(
	inss		    INT  PRIMARY KEY ,
	nombres			VARCHAR (30)		   NOT NULL,
	apellidos		VARCHAR (30)		   NOT NULL,
	telefono		INT					   NOT NULL,
	cedula			VARCHAR (20)		   NOT NULL,
	activo			INT					   NOT NULL
);

Go
IF OBJECT_ID('Responsable') IS NOT NULL
    PRINT '<<< CREATED TABLE Responsable >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE Responsable >>>'
Go

/* 
 * TABLE: usuario_R
 */

Create table usuario_R
(
	idUsuario_R	    INT  PRIMARY KEY IDENTITY (1,1),
	contrasenia			VARCHAR (30)		   NOT NULL,
	inss  			    INT		    		   NOT NULL,
	FOREIGN KEY (inss) REFERENCES Responsable(inss)
);

Go
IF OBJECT_ID('usuario_R') IS NOT NULL
    PRINT '<<< CREATED TABLE usuario_R >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE usuario_R >>>'
Go


/* 
 * TABLE: MarcaEquipo 
 */

 Create table MarcaEquipo
 (
	idMarca INT PRIMARY KEY IDENTITY(1,1),
	marca   VARCHAR (30) NOT NULL
 
 );


Go
IF OBJECT_ID('MarcaEquipo') IS NOT NULL
    PRINT '<<< CREATED TABLE MarcaEquipo >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE MarcaEquipo >>>'
Go


/* 
 * TABLE: Estado 
 */

 Create table Estado 
 (
	 idEstado INT PRIMARY KEY IDENTITY(1,1),
	 estado   VARCHAR(15) NOT NULL
 );

 Go
IF OBJECT_ID('Estado') IS NOT NULL
    PRINT '<<< CREATED TABLE Estado >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE Estado >>>'
Go

INSERT INTO  Estado
VALUES ('Bueno'),
	   ('Malo');


/* 
 * TABLE: EquipoTecnologico 
 */

Create table EquipoTecnologico
(
	idEquipoTecnologico	INT IDENTITY(1,1),
	inss				INT			 NOT NULL,
	numeroArt			INT			 NOT NULL,
	codigo				VARCHAR(30)  NOT NULL,
	etiqueta			VARCHAR(30)  NOT NULL,
	cantidad			INT			 NOT NULL,
	descripcion			VARCHAR(150) NOT NULL,
	modelo				VARCHAR(30)  NOT NULL,
	idMarca				INT					 ,
	serie				VARCHAR(20)  NOT NULL,
	costo				DOUBLE PRECISION (20)  NOT NULL,
	idEstado			INT				   	 ,
	observacion			VARCHAR(150) NOT NULL,
	activo				INT			 NOT NULL
	
	CONSTRAINT PK_EquipoTecnologico PRIMARY KEY NONCLUSTERED (idEquipoTecnologico),
	FOREIGN KEY (idMarca) REFERENCES MarcaEquipo(idMarca),
	FOREIGN KEY (idEstado) REFERENCES Estado(idEstado),
	FOREIGN KEY (inss) REFERENCES Custodio(inss)
);

Go
IF OBJECT_ID('EquipoTecnologico') IS NOT NULL
    PRINT '<<< CREATED TABLE EquipoTecnologico >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE EquipoTecnologico >>>'
Go


/* 
 * TABLE: EquipoMobiliario 
 */

CREATE TABLE EquipoMobiliario (
    idEquipoMobiliario INT IDENTITY(1,1) PRIMARY KEY,
	inss			   INT,
    numeroArticulo	   INT,
	etiqueta           VARCHAR (20),
	codigo			   VARCHAR (20),
    cantidad           INT,
    descripcion        VARCHAR(20),
    costo              DOUBLE PRECISION(20),
    idEstado		   INT,
    observacion        VARCHAR(30),
	activo			   INT,	
	FOREIGN KEY (idEstado) REFERENCES Estado(idEstado),
	FOREIGN KEY (inss) REFERENCES Custodio(inss)
);

Go
IF OBJECT_ID('EquipoMobiliario') IS NOT NULL
    PRINT '<<< CREATED TABLE EquipoMobiliario >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE EquipoMobiliario >>>'
Go


/* 
 * TABLE: Facultad 
 */

CREATE TABLE Facultad (
    idFacultad INT IDENTITY(1,1) PRIMARY KEY,
    Facultdad VARCHAR(50)
);

Go
IF OBJECT_ID('Facultad') IS NOT NULL
    PRINT '<<< CREATED TABLE Facultad >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE Facultad >>>'
Go

INSERT INTO  Facultad
VALUES ('Ciencias e Ingeniería');


/* 
 * TABLE: Recinto 
 */

CREATE TABLE Recinto (
    idRecinto INT IDENTITY(1,1) PRIMARY KEY,
    Recinto VARCHAR(50)
);

Go
IF OBJECT_ID('Recinto') IS NOT NULL
    PRINT '<<< CREATED TABLE Recinto >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE Recinto >>>'
Go

INSERT INTO  Recinto
VALUES ('Rubén Darío RURD-016P1001-C');


/* 
 * TABLE: Dependencia 
 */

CREATE TABLE Dependencia (
    IdDependencia INT IDENTITY(1,1) PRIMARY KEY,
    Departamento VARCHAR(50)
);

Go
IF OBJECT_ID('Dependencia') IS NOT NULL
    PRINT '<<< CREATED TABLE Dependencia >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE Dependencia >>>'
Go

INSERT INTO  Dependencia
VALUES ('Departamento de computación');

/* 
 * TABLE: Inventario 
 */

Create table Inventario
(
	idInventario	  INT  PRIMARY KEY identity(1,1),
	NumInventario	  INT		  NOT NULL,
	idFacultad        INT         NOT NULL,
    idRecinto		  INT		  NOT NULL,
    idDependencia	  INT		  NOT NULL,
    ResponsableInss   INT		  NOT NULL,
    CustodioInss      INT		  NOT NULL,
    FechaIngreso	  DATE		  NOT NULL,
	FOREIGN KEY (idFacultad) REFERENCES Facultad(idFacultad),
	FOREIGN KEY (idRecinto) REFERENCES Recinto(idRecinto),
	FOREIGN KEY (idDependencia) REFERENCES Dependencia(idDependencia)
);

Go
IF OBJECT_ID('Inventario') IS NOT NULL
    PRINT '<<< CREATED TABLE Inventario >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE Inventario >>>'
Go


/* 
 * TABLE: Detalle_Inv_EqMobiliario 
 */

CREATE TABLE Detalle_Inv_EqMobiliario (
  idDetalleInv INT PRIMARY KEY IDENTITY (1,1),
  idInventario INT ,
  idEquipoMobiliario INT,
  FOREIGN KEY (idInventario) REFERENCES Inventario(idInventario),
  FOREIGN KEY (idEquipoMobiliario) REFERENCES EquipoMobiliario(idEquipoMobiliario), 
);

Go
IF OBJECT_ID('Detalle_Inv_EqMobiliario') IS NOT NULL
    PRINT '<<< CREATED TABLE Detalle_Inv_EqMobiliario >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE Detalle_Inv_EqMobiliario >>>'
Go


/* 
 * TABLE: Detalle_Inv_EqTecnologico 
 */

CREATE TABLE Detalle_Inv_EqTecnologico (
  idDetalleInv INT PRIMARY KEY IDENTITY (1,1),
  idInventario INT ,
  idEquipoTecnologico INT,
  FOREIGN KEY (idInventario) REFERENCES Inventario(idInventario),
  FOREIGN KEY (idEquipoTecnologico) REFERENCES EquipoTecnologico(idEquipoTecnologico), 
);

Go
IF OBJECT_ID('Detalle_Inv_EqTecnologico') IS NOT NULL
    PRINT '<<< CREATED TABLE Detalle_Inv_EqTecnologico >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE Detalle_Inv_EqTecnologico >>>'
Go


/* 
 * TABLE: Laboratorio 
 */

Create table Laboratorio
(
	idLab			INT PRIMARY KEY IDENTITY (1,1),
	numeroLab		VARCHAR (10),
	Estado			VARCHAR (30)
);

Go
IF OBJECT_ID('Laboratorio') IS NOT NULL
    PRINT '<<< CREATED TABLE Laboratorio >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE Laboratorio >>>'
Go


/* 
 * TABLE: EncargadoLlab 
 */

 Create table EncargadoLlab
(
	idEncargado		INT PRIMARY KEY IDENTITY (1,1),
	idLab			INT,
	noCarnet		INT NOT NULL,
	fechaEntrada    DATE,
	fechaSalida	    DATE,
	FOREIGN KEY (noCarnet) REFERENCES Instructor(noCarnet),
	FOREIGN KEY (idLab) REFERENCES Laboratorio(idLab)
);

Go
IF OBJECT_ID('EncargadoLlab') IS NOT NULL
    PRINT '<<< CREATED TABLE EncargadoLlab >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE EncargadoLlab >>>'
Go


/* 
 * TABLE: Tipo_Movimiento 
 */

Create table Tipo_Movimiento
(
	idTipoMovimiento INT PRIMARY KEY IDENTITY(1,1),
	tipoMovimiento	 VARCHAR (25)		  not null
);

Insert into dbo.Tipo_Movimiento 
VALUES('Traslado'),
	  ('Mantenimiento'),
	  ('Asignacion');

Go
IF OBJECT_ID('Tipo_Movimiento') IS NOT NULL
    PRINT '<<< CREATED TABLE Tipo_Movimiento >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE Tipo_Movimiento >>>'
Go

/* 
 * TABLE: Movimiento 
 */

	CREATE TABLE Movimiento (
		noMovimiento	INT PRIMARY KEY ,
		inss			INT,
		idLab			INT,
		idTpMovimiento  INT,
		Fecha			DATE,
		LocacionNueva  VARCHAR(30),
		Observacion     VARCHAR(200),
		FOREIGN KEY (inss) REFERENCES Responsable(inss),
		FOREIGN KEY (idTpMovimiento) REFERENCES Tipo_Movimiento(idTipoMovimiento),
		FOREIGN KEY (idLab) REFERENCES Laboratorio(idLab)
	);

Go
IF OBJECT_ID('Movimiento') IS NOT NULL
    PRINT '<<< CREATED TABLE Movimiento >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE Movimiento >>>'
Go


/* 
 * TABLE: detalleMovEqMob 
 */

CREATE TABLE detalleMovEqMob (
  idDetalleMovEqMob INT PRIMARY KEY IDENTITY (1,1),
  noMovmiento  INT ,
  idEquipoMobiliario  INT,
  FOREIGN KEY (noMovmiento) REFERENCES Movimiento(noMovimiento),
  FOREIGN KEY (idEquipoMobiliario) REFERENCES EquipoMobiliario(idEquipoMobiliario), 
);

Go
IF OBJECT_ID('detalleMovEqMob') IS NOT NULL
    PRINT '<<< CREATED TABLE detalleMovEqMob >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE detalleMovEqMob >>>'
Go


/* 
 * TABLE: detalleMovEqTec 
 */

CREATE TABLE detalleMovEqTec (
  idDetalleMovEqTec INT PRIMARY KEY IDENTITY (1,1),
  noMovmiento  INT ,
  idEquipoTecnologico INT,
  FOREIGN KEY (noMovmiento) REFERENCES Movimiento(noMovimiento),
  FOREIGN KEY (idEquipoTecnologico) REFERENCES EquipoTecnologico(idEquipoTecnologico), 
);

Go
IF OBJECT_ID('detalleMovEqTec') IS NOT NULL
    PRINT '<<< CREATED TABLE detalleMovEqTec >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE detalleMovEqTec >>>'
Go

insert into MarcaEquipo values
('Dell'),
('Lenovo')


Go

create schema Inventory;
Go
/******************* Principales procedimientos, funciones y consultas*************************/
--FUNCTION: Porcentaje de equipos malos
	CREATE OR ALTER FUNCTION [Inventory].[CalcularPorcentajeEquiposMalos]()
	RETURNS FLOAT
	AS
	BEGIN
	DECLARE @Porcentaje FLOAT;
			
	SELECT @Porcentaje = (CAST(SUM(CantidadEquiposMalos) AS FLOAT) / SUM(CantidadTotalEquipos)) * 100
	FROM (
	SELECT COUNT(*) AS CantidadEquiposMalos, 0 AS CantidadTotalEquipos
	FROM EquipoTecnologico
	WHERE idEstado = 2
	UNION ALL
	SELECT 0 AS CantidadEquiposMalos, COUNT(*) AS CantidadTotalEquipos
	FROM EquipoTecnologico

	UNION ALL

	SELECT COUNT(*) AS CantidadEquiposMalos, 0 AS CantidadTotalEquipos
	FROM EquipoMobiliario
	WHERE idEstado = 2

	UNION ALL

	SELECT 0 AS CantidadEquiposMalos, COUNT(*) AS CantidadTotalEquipos
	FROM EquipoMobiliario
	) AS EquiposMalosTotales;

	RETURN @Porcentaje;
	END;
Go
--FUNCTION: Porcentaje de equipos buenos							
	CREATE OR ALTER FUNCTION [Inventory].[CalcularPorcentajeEquiposBuenos]()
	RETURNS FLOAT
	AS
	BEGIN
	DECLARE @Porcentaje FLOAT;

	SELECT @Porcentaje = (CAST(SUM(CantidadEquiposBuenos) AS FLOAT) / SUM(CantidadTotalEquipos)) * 100
	FROM (
	SELECT COUNT(*) AS CantidadEquiposBuenos, 0 AS [CantidadTotalEquipos]
	FROM EquipoTecnologico
	WHERE idEstado = 1

	UNION ALL

	SELECT 0 AS CantidadEquiposBuenos, COUNT(*) AS [CantidadTotalEquipos]
	FROM EquipoTecnologico

	UNION ALL

	SELECT COUNT(*) AS CantidadEquiposBuenos, 0 AS [CantidadTotalEquipos]
	FROM EquipoMobiliario
	WHERE idEstado = 1

	UNION ALL

	SELECT 0 AS CantidadEquiposBuenos, COUNT(*) AS [CantidadTotalEquipos]
	FROM EquipoMobiliario
	) AS EquiposBuenosTotales;
	RETURN @Porcentaje;
	END;
Go
-- VIEW: Total de equipos en inventario
	CREATE OR ALTER VIEW [Inventory].[InventariosALLView]
		AS
		   SELECT
				I.NumInventario,
				COUNT(*) AS [Cantidad de equipos],
				I.FechaIngreso
			FROM
				Inventario AS I
			JOIN
				(
				SELECT
					idInventario,
					idEquipoTecnologico AS EquipoID
				FROM
					Detalle_Inv_EqTecnologico
				UNION ALL
				SELECT
					idInventario,
					idEquipoMobiliario AS EquipoID
				FROM
					Detalle_Inv_EqMobiliario
				) AS Equipos
			ON
				I.idInventario = Equipos.idInventario
			GROUP BY
				I.NumInventario, I.FechaIngreso;
		Go
-- FUNCTION: Verificar registro de custodio
		CREATE OR ALTER PROCEDURE [Inventory].[LoginCustodio]
		(
			@contrasenia VARCHAR(30),
			@inss INT
		)
		AS
		BEGIN
			SELECT
				COUNT(*) AS [Count],
				MAX(CUS.nombres + ' ' + CUS.apellidos) AS [Nombre]
			FROM
				usuario_c AS C
				INNER JOIN Custodio AS CUS ON CUS.inss = C.inss
			WHERE
				C.inss = @inss
				AND C.contrasenia = @contrasenia
		END;
Go
--PROCEDURE: Agregar custodio
		CREATE OR ALTER PROCEDURE [Inventory].[Ingresar custodio]
			@inss int,
			@nombres varchar(30),
			@apellidos varchar(30),
			@telefono int,
			@cedula varchar(30),
			@activo int
			AS
			BEGIN
				BEGIN TRY
					BEGIN TRANSACTION;

					INSERT INTO Custodio VALUES (@inss, @nombres, @apellidos, @telefono, @cedula, @activo);

					COMMIT TRAN;
				END TRY
				BEGIN CATCH
					IF @@TRANCOUNT > 0
						ROLLBACK TRAN;

					THROW;
				END CATCH;
			END;
			Go
--VIEW: Buscar custodio	
		CREATE OR ALTER VIEW [Inventory].[CustodioBuscarView]
			AS
			SELECT inss, nombres, apellidos, telefono, cedula, activo
			FROM Custodio
Go
--PROCEDURE: Actualizar custodio
		CREATE OR ALTER PROCEDURE [Inventory].[Actualizar Custodio]
			@inss INT,
			@nombres VARCHAR(30),
			@apellidos VARCHAR(30),
			@telefono INT,
			@cedula VARCHAR(30),
			@activo INT
		AS
		BEGIN
			BEGIN TRY
				BEGIN TRANSACTION;

				UPDATE Custodio
				SET nombres = @nombres,
					apellidos = @apellidos,
					telefono = @telefono,
					cedula = @cedula,
					activo = @activo
				WHERE inss = @inss;

				COMMIT TRANSACTION;

				PRINT 'Custodio actualizado correctamente.';
			END TRY
			BEGIN CATCH
				IF @@TRANCOUNT > 0
					ROLLBACK TRANSACTION;

				DECLARE @ErrorMessage NVARCHAR(MAX);
				DECLARE @ErrorSeverity INT;
				DECLARE @ErrorState INT;

				SELECT
					@ErrorMessage = ERROR_MESSAGE(),
					@ErrorSeverity = ERROR_SEVERITY(),
					@ErrorState = ERROR_STATE();

				RAISERROR(@ErrorMessage, @ErrorSeverity, @ErrorState);
			END CATCH;
		END;
GO
--FUNCTION: Verificar custodio custodio	
		CREATE OR ALTER FUNCTION [Inventory].[VerificarInssRegistrado](@inss INT)
		RETURNS INT
		AS
		BEGIN
		DECLARE @count INT;
		SELECT @count = COUNT(*) FROM Custodio WHERE inss = @inss;
		RETURN @count;
	    END;	
Go
--PROCEDURE: Borrar custodio
	CREATE OR ALTER PROCEDURE [Inventory].[BorradoLogico]
			@activo INT,
			@inss INT
		AS
		BEGIN
		BEGIN TRY
			BEGIN TRANSACTION;

			UPDATE Custodio
			SET activo = @activo
			WHERE inss = @inss;

			COMMIT TRANSACTION;

			PRINT 'Borrado lógico realizado correctamente.';
		END TRY
		BEGIN CATCH
			IF @@TRANCOUNT > 0
				ROLLBACK TRANSACTION;

			DECLARE @ErrorMessage NVARCHAR(MAX);
			DECLARE @ErrorSeverity INT;
			DECLARE @ErrorState INT;

			SELECT
				@ErrorMessage = ERROR_MESSAGE(),
				@ErrorSeverity = ERROR_SEVERITY(),
				@ErrorState = ERROR_STATE();

			RAISERROR(@ErrorMessage, @ErrorSeverity, @ErrorState);
		END CATCH;
		END;
GO
-- PROCEDURE: Listar custodio
	CREATE OR ALTER PROCEDURE [Inventory].[ObtenerCustodios]
		AS
		BEGIN
		BEGIN TRY
			SELECT inss, nombres, apellidos, telefono, cedula
			FROM Custodio as C
			WHERE activo = 1;
		END TRY
		BEGIN CATCH
			DECLARE @ErrorMessage NVARCHAR(MAX);
			DECLARE @ErrorSeverity INT;
			DECLARE @ErrorState INT;

			SELECT
				@ErrorMessage = ERROR_MESSAGE(),
				@ErrorSeverity = ERROR_SEVERITY(),
				@ErrorState = ERROR_STATE();

			RAISERROR(@ErrorMessage, @ErrorSeverity, @ErrorState);
		END CATCH;
		END;
GO
-- PROCUDER: Guardar contraseña de custodio
		CREATE OR ALTER PROCEDURE [Inventory].[GuardarContraseniaCus]
		@contrasenia VARCHAR(30),
		@inss INT
		AS
		BEGIN
			INSERT INTO usuario_c VALUES (@contrasenia,@inss)
		END;
	
Go
-- PROCUDER: ACTUALIZAR CONTRASEÑA DE CUSTODIO
		CREATE OR ALTER PROCEDURE [Inventory].[ActualizarContraseniaCus]
			@contrasenia VARCHAR(30),
			@inss INT
		AS
		BEGIN
		BEGIN TRY
			UPDATE usuario_c
			SET contrasenia = @contrasenia
			WHERE inss = @inss;
		END TRY
		BEGIN CATCH
			DECLARE @ErrorMessage NVARCHAR(MAX);
			DECLARE @ErrorSeverity INT;
			DECLARE @ErrorState INT;

			SELECT
				@ErrorMessage = ERROR_MESSAGE(),
				@ErrorSeverity = ERROR_SEVERITY(),
				@ErrorState = ERROR_STATE();

			RAISERROR(@ErrorMessage, @ErrorSeverity, @ErrorState);
		END CATCH;
		END;
GO
--VIEW: Buscar contraseña de custodio	
		CREATE OR ALTER VIEW [Inventory].[CustodioBuscarContraseñaView]
			AS
			SELECT contrasenia, inss
			FROM usuario_c;
GO
-- PROCEDURE: Listar custodios
		CREATE OR ALTER PROCEDURE [Inventory].[ObtenerCustodiosContra]
			AS
			BEGIN
			BEGIN TRY
				SELECT usuario_c.inss, nombres, apellidos, usuario_c.contrasenia
				FROM usuario_c
				INNER JOIN Custodio as C on C.inss = usuario_c.inss
				WHERE C.activo = 1;
			END TRY
			BEGIN CATCH
				DECLARE @ErrorMessage NVARCHAR(MAX);
				DECLARE @ErrorSeverity INT;
				DECLARE @ErrorState INT;

				SELECT
					@ErrorMessage = ERROR_MESSAGE(),
					@ErrorSeverity = ERROR_SEVERITY(),
					@ErrorState = ERROR_STATE();

				RAISERROR(@ErrorMessage, @ErrorSeverity, @ErrorState);
			END CATCH;
			END;
GO

/******************* Instructor *************************/

--PROCEDURE: Agregar 
		 CREATE OR ALTER PROCEDURE [Inventory].[Ingresar Instructor]
		 @numCarnet INT, @nombres VARCHAR(30), @apellidos VARCHAR(30),  @telefono int, 
		 @cedula VARCHAR(30),@activo INT
	     AS
		 BEGIN
		 INSERT INTO Instructor VALUES (@numCarnet,@nombres,@apellidos,@telefono,@cedula,@activo)
		 END;
Go	
--VIEW: Buscar
         CREATE OR ALTER VIEW [Inventory].[InstructorBuscarView]
		 AS	  
		 SELECT noCarnet, nombres, apellidos, telefono, cedula, activo
	     FROM Instructor;
Go
--PROCEDURE: Actualizar 
		 CREATE OR ALTER PROCEDURE [Inventory].[Actualizar Instructor]
		 @numCarnet INT, @nombres VARCHAR(30), @apellidos VARCHAR(30),  @telefono INT, 
		 @cedula VARCHAR(30), @activo INT
	     AS
		 BEGIN
		 UPDATE Instructor
                SET Instructor.nombres = @nombres, Instructor.apellidos = @apellidos,
                Instructor.telefono = @telefono, Instructor.cedula = @cedula,
                Instructor.activo = @activo
                WHERE Instructor.noCarnet = @numCarnet
		 END;
GO
--FUNCTION: Verificar Instrucor	
		CREATE OR ALTER FUNCTION [Inventory].[VerificarnumCarnetRegistrado](@numCarnet INT)
		RETURNS INT
		AS
		BEGIN
		DECLARE @count INT;
		SELECT @count = COUNT(*) FROM Instructor WHERE noCarnet = @numCarnet;
		RETURN @count;
	    END;
Go
--PROCEDURE: Borrar
		CREATE OR ALTER PROCEDURE [Inventory].[BorradoLogicoInstructor]
		@activo INT,
		@numCarnet INT
		AS
		BEGIN
			UPDATE Instructor
			SET activo = @activo
			WHERE noCarnet = @numCarnet;
		END;
Go
--PROCEDURE: Listar
		CREATE OR ALTER PROCEDURE [Inventory].[ObtenerInstructores]
		AS
		BEGIN
			SELECT noCarnet, nombres, apellidos, telefono, cedula
			FROM Instructor
			WHERE activo = 1;
		END;
GO
-- PROCUDER: GUARDAR CONTRASEÑA
		CREATE OR ALTER PROCEDURE [Inventory].[GuardarContraseniaIns]
		@contrasenia VARCHAR(30),
		@noCarnet INT
		AS
		BEGIN
			INSERT INTO usuario_I VALUES (@contrasenia,@noCarnet)
		END;
	
Go
-- PROCUDER: ACTUALIZAR CONTRASEÑA
		CREATE OR ALTER PROCEDURE [Inventory].[ActualizarContraseniaIns]
		@contrasenia VARCHAR(30),
		@noCarnet INT
		AS
		BEGIN
			UPDATE usuario_I SET contrasenia= @contrasenia
			where noCarnet = @noCarnet
		END;
Go
--VIEW: Buscar contraseña		
		CREATE OR ALTER VIEW [Inventory].[InstructorBuscarContrasenaView]
		AS
		SELECT contrasenia, noCarnet
		FROM usuario_I
Go
-- PROCEDURE: Listar
		CREATE OR ALTER	PROCEDURE [Inventory].[ObteneInstructorContra]
		AS
		BEGIN
			SELECT usuario_I.noCarnet, nombres, apellidos,usuario_I.contrasenia
			FROM usuario_I
			INNER JOIN Instructor as I on I.noCarnet = usuario_I.noCarnet
			WHERE I.activo = 1;
		END;
Go

/******************* Responsable *************************/

--PROCEDURE: agregar 
		 CREATE OR ALTER PROCEDURE [Inventory].[Ingresar Responsable]
		 @inss INT, @nombres VARCHAR(30), @apellidos VARCHAR(30),  @telefono INT, 
		 @cedula VARCHAR(30), @activo INT
	     AS
		 BEGIN
		 INSERT INTO Responsable VALUES (@inss,@nombres,@apellidos,@telefono,@cedula,@activo)
		 END;		
Go
--VIEW: Buscar	
		CREATE OR ALTER VIEW [Inventory].[ResponsableBuscarView]
		AS
		SELECT inss, nombres, apellidos, telefono, cedula, activo
		FROM Responsable
Go		 
-- PROCEDURE: Actualizar
		 CREATE OR ALTER PROCEDURE [Inventory].[Actualizar Responsable]
		 @inss INT, @nombres VARCHAR(30), @apellidos VARCHAR(30),  @telefono INT, 
		 @cedula VARCHAR(30), @activo INT
	     AS
		 BEGIN
		 UPDATE Responsable
                SET Responsable.nombres = @nombres, Responsable.apellidos = @apellidos,
                Responsable.telefono = @telefono, Responsable.cedula = @cedula,
                Responsable.activo = @activo
                WHERE Responsable.inss = @inss
		 END;
Go
--FUNCTION: Verificar Responsable
		CREATE OR ALTER FUNCTION [Inventory].[VerificarInssRegistradoResponsable](@inss INT)
		RETURNS INT
		AS
		BEGIN
		DECLARE @count INT;
		SELECT @count = COUNT(*) FROM Responsable WHERE inss = @inss;
		RETURN @count;
	    END;	
GO
--PROCEDURE: Borrar
		CREATE OR ALTER PROCEDURE [Inventory].[BorradoLogicoResponsable]
		@activo INT,
		@inss INT
		AS
		BEGIN
			UPDATE Responsable
			SET activo = @activo
			WHERE inss = @inss;
		END;
Go
--Listar
		CREATE OR ALTER PROCEDURE [Inventory].[ObtenerResponsables]
		AS
		BEGIN
			SELECT inss, nombres, apellidos, telefono, cedula
			FROM Responsable
			WHERE activo = 1;
		END;
Go
-- PROCUDER: GUARDAR CONTRASEÑA
		CREATE OR ALTER PROCEDURE [Inventory].[GuardarContraseniaRes]
		@contrasenia VARCHAR(30),
		@inss INT
		AS
		BEGIN
			INSERT INTO usuario_R VALUES (@contrasenia,@inss)
		END;
	
Go
-- PROCUDER: ACTUALIZAR CONTRASEÑA
		CREATE OR ALTER PROCEDURE [Inventory].[ActualizarContraseniaRes]
		@contrasenia VARCHAR(30),
		@inss INT
		AS
		BEGIN
			UPDATE usuario_R SET contrasenia= @contrasenia
			where inss = @inss
		END;
Go
--VIEW: Buscar contraseña		
		CREATE OR ALTER VIEW [Inventory].[ResponsableBuscarContrasenaView]
		AS
		SELECT contrasenia, inss
		FROM usuario_R
Go
-- PROCEDURE: Listar
		CREATE OR ALTER PROCEDURE [Inventory].[ObteneResponsableContra]
		AS
		BEGIN
			SELECT usuario_R.inss, nombres, apellidos, usuario_R.contrasenia
			FROM usuario_R
			INNER JOIN Responsable as R on R.inss = usuario_R.inss
			WHERE R.activo = 1;
		END;
Go
		/******************* Equipo tecnologico *************************/
-- PROCEDURE: Agregar
			CREATE OR ALTER PROCEDURE [Inventory].[InsertarEquipoTecnologico]
				@inss INT,@numeroArt INT,@codigo VARCHAR(50),@etiqueta VARCHAR(50),@cantidad INT,
				@descripcion VARCHAR(100),@modelo VARCHAR(50),@idMarca INT,@serie VARCHAR(50),
				@costo DECIMAL(10,2),@idEstado INT,@observacion VARCHAR(100),@activo INT
			AS
			BEGIN
				INSERT INTO EquipoTecnologico (inss, numeroArt, codigo, etiqueta, cantidad, descripcion, modelo, idMarca, serie, costo, idEstado, observacion, activo)
				VALUES (@inss, @numeroArt, @codigo, @etiqueta, @cantidad, @descripcion, @modelo, @idMarca, @serie, @costo, @idEstado, @observacion, @activo)
			END;
Go
--PROCEDURE: Actualizar
			CREATE OR ALTER PROCEDURE [Inventory].[ActualizarEquipo]
			@inss INT,@cantidad INT,@descripcion VARCHAR(255),@modelo VARCHAR(50),@idMarca INT,
			@serie VARCHAR(50),@costo DECIMAL(10, 2),@idEstado INT,	@observacion VARCHAR(255),
			@activo INT,@numeroArt INT
		AS
		BEGIN
			UPDATE EquipoTecnologico
			SET inss = @inss,cantidad = @cantidad,descripcion = @descripcion,modelo = @modelo,
			    IdMarca = @idMarca,serie = @serie,costo = @costo,idEstado = @idEstado,
				observacion = @observacion,
				activo = @activo
			WHERE numeroArt = @numeroArt;
		END;
Go
--VIEW: Buscar equipos tecnologicos
			CREATE OR ALTER VIEW [Inventory].[BuscarEquipoTecnologicoView]
			AS
			SELECT C.inss,C.nombres, ET.numeroArt,ET.codigo,ET.etiqueta, ET.cantidad, ET.descripcion, ET.modelo,
				   ME.marca, ET.serie, ET.costo, E.estado, ET.observacion, ET.activo
			FROM EquipoTecnologico AS ET
			INNER JOIN Estado AS E ON E.idEstado = ET.idEstado
			INNER JOIN MarcaEquipo AS ME ON ET.idMarca = ME.idMarca
			INNER JOIN Custodio as C ON C.inss = ET.inss;
Go
-- FUNCTION: Verificar equipos
		CREATE OR ALTER FUNCTION [Inventory].[VerificarEquipoTecnologico]
		(
			@numeroArt int
		)
		RETURNS int
		AS
		BEGIN
			DECLARE @count int;
			SET @count = (SELECT COUNT(*) FROM EquipoTecnologico WHERE numeroArt = @numeroArt);
			RETURN @count;
		END;
Go
-- PROCEDURE: Borrar
			CREATE OR ALTER PROCEDURE [Inventory].[Borrar Equipo]
			@numeroArt INT,
			@activo INT
		AS
		BEGIN
			UPDATE EquipoTecnologico
			SET activo = @activo
			WHERE numeroArt = @numeroArt
		END;
Go
-- VIEW: Listar Estado cmb
		CREATE OR ALTER VIEW [Inventory].[EstadoView]
		AS
		SELECT estado
		FROM Estado
Go
-- VIEW: Listar marca cmb
		CREATE OR ALTER VIEW [Inventory].[MarcaView]
		AS
		SELECT marca
		FROM MarcaEquipo
Go
-- FUNCTION: Obtener Id de la Marca
		CREATE OR ALTER FUNCTION [Inventory].[ObtenerIdMarca]
		(
			@nombreMarca VARCHAR(50)
		)
		RETURNS INT
		AS
		BEGIN
			DECLARE @idMarca INT;
    
			SELECT @idMarca = idMarca
			FROM MarcaEquipo
			WHERE marca = @nombreMarca;
    
			RETURN @idMarca;
		END;
Go
-- FUNCTION: Obtener Id del estado
			CREATE OR ALTER FUNCTION [Inventory].[ObtenerIdEstado]
			(
				@estado VARCHAR(50)
			)
			RETURNS INT
			AS
			BEGIN
				DECLARE @idEstado INT;

				SELECT @idEstado = idEstado
				FROM Estado
				WHERE estado = @estado;

				RETURN @idEstado;
			END;
Go
-- PROCEDURE: Listar
		CREATE or ALTER PROCEDURE [Inventory].[ObtenerDatosEquipoTecnologico]
		AS
		BEGIN
			SELECT C.nombres + ' '+ C.apellidos, ET.etiqueta, ET.cantidad, ET.descripcion,
				   ME.marca, E.estado, ET.observacion
			FROM EquipoTecnologico AS ET
			INNER JOIN Estado AS E ON E.idEstado = ET.idEstado
			INNER JOIN MarcaEquipo AS ME ON ET.idMarca = ME.idMarca
			INNER JOIN Custodio as C ON C.inss = ET.inss
			Where ET.activo = 1;
		END;
Go
-- VIEW: Equipos tecnologico malos
			CREATE OR ALTER VIEW [Inventory].[EquipoTecnologicoMalosView]
			AS
				SELECT C.nombres + ' '+ C.apellidos as custodio, ET.etiqueta, ET.cantidad, ET.descripcion,
				   ME.marca, E.estado, ET.observacion
			FROM EquipoTecnologico AS ET
			INNER JOIN Estado AS E ON E.idEstado = ET.idEstado
			INNER JOIN MarcaEquipo AS ME ON ET.idMarca = ME.idMarca
			INNER JOIN Custodio as C ON C.inss = ET.inss
			Where ET.activo = 1 AND E.idEstado = 2;
Go

-- VIEW: Equipos tecnologico buenos
			CREATE OR ALTER  VIEW [Inventory].[EquipoTecnologicoBuenosView]
			AS
				SELECT C.nombres + ' '+ C.apellidos as custodio, ET.etiqueta, ET.cantidad, ET.descripcion,
				   ME.marca, E.estado, ET.observacion
			FROM EquipoTecnologico AS ET
			INNER JOIN Estado AS E ON E.idEstado = ET.idEstado
			INNER JOIN MarcaEquipo AS ME ON ET.idMarca = ME.idMarca
			INNER JOIN Custodio as C ON C.inss = ET.inss
			Where ET.activo = 1 AND E.idEstado = 1;
Go
-- VIEW: Equipos tecnologico inactivos
			CREATE OR ALTER VIEW [Inventory].[EquipoTecnologicoInactivosView]
			AS
				SELECT C.nombres + ' '+ C.apellidos as custodio, ET.etiqueta,ET.cantidad, ET.descripcion,
				   ME.marca, E.estado, ET.observacion
			FROM EquipoTecnologico AS ET
			INNER JOIN Estado AS E ON E.idEstado = ET.idEstado
			INNER JOIN MarcaEquipo AS ME ON ET.idMarca = ME.idMarca
			INNER JOIN Custodio as C ON C.inss = ET.inss
			WHERE ET.activo =0;
Go

		/******************* Equipo Mobiliario *************************/
-- PROCEDURE: Agregar
			CREATE OR ALTER PROCEDURE [Inventory].[InsertarEquipoMobiliario]
				@inss INT,@numeroArt INT,@codigo VARCHAR(50),@etiqueta VARCHAR(50),@cantidad INT,
				@descripcion VARCHAR(100),@costo DECIMAL(10,2),@idEstado INT,@observacion VARCHAR(100),@activo INT
			AS
			BEGIN
				INSERT INTO EquipoMobiliario (inss, numeroArticulo, codigo, etiqueta, cantidad, descripcion, costo, idEstado, observacion, activo)
				VALUES (@inss, @numeroArt, @codigo, @etiqueta, @cantidad, @descripcion, @costo, @idEstado, @observacion, @activo)
			END;
Go
--VIEW: Buscar
			CREATE OR ALTER VIEW [Inventory].[BuscarEquipoMobiliarioView]
			AS
			SELECT C.inss,C.nombres, EM.numeroArticulo,EM.codigo,EM.etiqueta, EM.cantidad, EM.descripcion,
			EM.costo, E.estado, EM.observacion, EM.activo
			FROM EquipoMobiliario AS EM
			INNER JOIN Estado AS E ON E.idEstado = EM.idEstado
			INNER JOIN Custodio as C ON C.inss = EM.inss;
	Go


--PROCEDURE: Actualizar
			CREATE OR ALTER PROCEDURE [Inventory].[ActualizarEquipoMobiliario]
			@inss INT,@cantidad INT,@descripcion VARCHAR(255),@costo DECIMAL(10, 2)
			,@idEstado INT,	@observacion VARCHAR(255),
			@activo INT,@numeroArt INT
		AS
		BEGIN
			UPDATE EquipoMobiliario
			SET inss = @inss,cantidad = @cantidad,descripcion = @descripcion,
			costo = @costo,idEstado = @idEstado,
				observacion = @observacion,
				activo = @activo
			WHERE numeroArticulo = @numeroArt;
		END;
Go
-- FUNCTION: Verificar equipos
		CREATE OR ALTER FUNCTION [Inventory].[VerificarEquipoMobiliario]
		(
			@numeroArt int
		)
		RETURNS int
		AS
		BEGIN
			DECLARE @count int;
			SET @count = (SELECT COUNT(*) FROM EquipoMobiliario WHERE numeroArticulo = @numeroArt);
			RETURN @count;
		END;
Go
-- PROCEDURE: Borrar
			CREATE OR ALTER PROCEDURE [Inventory].[BorrarEquipoMobiliario]
			@numeroArt int,
			@activo int
		AS
		BEGIN
			UPDATE EquipoMobiliario
			SET activo = @activo
			WHERE numeroArticulo = @numeroArt
		END;
Go
-- VIEW: Equipos mobliarios malos
			CREATE OR ALTER VIEW [Inventory].[EquipoMobiliarioMalosView]
			AS
			SELECT C.nombres + ' '+ C.apellidos as custodio, ET.etiqueta, ET.cantidad, ET.descripcion, E.estado, ET.observacion
			FROM EquipoMobiliario AS ET
			INNER JOIN Estado AS E ON E.idEstado = ET.idEstado
			INNER JOIN Custodio AS C ON C.inss = ET.inss
			WHERE ET.activo = 1 AND E.idEstado = 2;
Go
-- VIEW: Equipos mobliarios buenos
			CREATE OR ALTER VIEW [Inventory].[EquipoMobiliarioBuenosView]
			AS
			SELECT C.nombres + ' '+ C.apellidos as custodio, ET.etiqueta, ET.cantidad, ET.descripcion, E.estado, ET.observacion
			FROM EquipoMobiliario AS ET
			INNER JOIN Estado AS E ON E.idEstado = ET.idEstado
			INNER JOIN Custodio AS C ON C.inss = ET.inss
			WHERE ET.activo = 1 AND E.idEstado = 1;
Go
-- VIEW: Equipos mobliarios inactivos
			CREATE OR ALTER VIEW [Inventory].[EquipoMobiliarioInactivoView]
			AS
			SELECT C.nombres + ' '+ C.apellidos as Custodio, ET.etiqueta, ET.cantidad, ET.descripcion, E.estado, ET.observacion
			FROM EquipoMobiliario AS ET
			INNER JOIN Estado AS E ON E.idEstado = ET.idEstado
			INNER JOIN Custodio AS C ON C.inss = ET.inss
			WHERE ET.activo = 0;
Go
		CREATE OR ALTER PROCEDURE [Inventory].[ObtenerDatosEquipoMobiliario]
		AS
		BEGIN
			SELECT C.nombres + ' '+ C.apellidos, ET.etiqueta, ET.cantidad, ET.descripcion
					 ,E.estado, ET.observacion
			FROM EquipoMobiliario AS ET
			INNER JOIN Estado AS E ON E.idEstado = ET.idEstado
			INNER JOIN Custodio as C ON C.inss = ET.inss
			Where ET.activo = 1
		END;
Go

	/******************* Inventario *************************/
-- PROCEDURE: agregar
			CREATE OR ALTER PROCEDURE [Inventory].[AgregarInventario]
			@numInventario int, @idFacultdad int , @idRecinto int, @idDepartamento int,
			@Responsableinss int, @Custodioinss int, @fechaIngreso date
		AS
		BEGIN
			INSERT INTO Inventario(Inventario.NumInventario,Inventario.idFacultad,Inventario.idRecinto,
			Inventario.idDependencia,Inventario.ResponsableInss,Inventario.CustodioInss,Inventario.FechaIngreso)
			VALUES(@numInventario,@idFacultdad,@idRecinto,@idDepartamento,@Responsableinss,@Custodioinss
			,@fechaIngreso)
		END;
Go
-- VIEW: Total  de inventario 
			CREATE OR ALTER  VIEW [Inventory].[InventariosView]
		AS
			SELECT COUNT(*) as  Total FROM Inventario
Go
-- FUNCTION: Verificar inventario
		CREATE OR ALTER FUNCTION [Inventory].[VerificarInventario]
		(
			@numeroInv int
		)
		RETURNS int
		AS
		BEGIN
			DECLARE @count int;
			SET @count = (SELECT COUNT(*) FROM Inventario WHERE NumInventario = @numeroInv);
			RETURN @count;
		END;
Go
-- PROCEDURE: Listar
		CREATE OR ALTER PROCEDURE [Inventory].[InventarioCatEquiposTec]
		AS
		BEGIN
			SELECT I.NumInventario, COUNT(Eq.idEquipoTecnologico) as [Total de equipos], I.FechaIngreso  FROM Detalle_Inv_EqTecnologico as  Eq
			INNER JOIN Inventario as I on I.idInventario =Eq.idInventario
			GROUP BY I.NumInventario, I.FechaIngreso
		END;
Go
-- VIEW: Equipos tecnologicos en inventaio
			CREATE OR ALTER procedure [Inventory].[EquiposTecInventario]
			@numInventario int
			AS
				SELECT I.NumInventario,E.numeroArt, E.descripcion, ES.estado, I.FechaIngreso FROM Inventario AS I
				INNER JOIN Detalle_Inv_EqTecnologico AS D ON D.idInventario = I.idInventario
				INNER JOIN EquipoTecnologico AS E ON E.idEquipoTecnologico =D.idEquipoTecnologico
				INNER JOIN Estado AS ES on ES.idEstado = E.idEstado
				where I.NumInventario = @numInventario
Go -- Reporte
--VIEW: Buscar		
		CREATE OR ALTER VIEW [Inventory].[InventarioBuscarView]
		AS
			SELECT I.NumInventario, R.nombres + ' ' + R.apellidos AS Responsable, C.nombres + ' ' + C.apellidos AS Custodio, I.FechaIngreso 
			FROM Inventario AS I
			inner JOIN Responsable AS R ON R.inss = I.ResponsableInss
			inner JOIN Custodio AS C ON C.inss = I.CustodioInss;
Go
-- PROCEDURE: Listar
		CREATE OR ALTER PROCEDURE [Inventory].[InventarioCatEquiposMob]
		AS
		BEGIN
			SELECT I.NumInventario, COUNT(Eq.idEquipoMobiliario) as [Total de equipos], I.FechaIngreso  FROM Detalle_Inv_EqMobiliario as  Eq
			INNER JOIN Inventario as I on I.idInventario =Eq.idInventario
			GROUP BY I.NumInventario, I.FechaIngreso
		END;
Go
-- VIEW: Equipos mobiliarios en inventaio
			CREATE OR ALTER PROCEDURE [Inventory].[EquiposMobInventario]
			@numInventario INT
			AS
			SELECT I.NumInventario,E.numeroArticulo, E.descripcion, ES.estado, I.FechaIngreso FROM Inventario AS I
			INNER JOIN Detalle_Inv_EqMobiliario AS D ON D.idInventario = I.idInventario
			INNER JOIN EquipoMobiliario AS E ON E.idEquipoMobiliario =D.idEquipoMobiliario
			INNER JOIN Estado AS ES on ES.idEstado = E.idEstado
			where I.NumInventario = @numInventario
Go

	/******************* Detalle de inventario de equipo tecnologico *************************/
-- PROCEDURE: AGREGAR
		CREATE OR ALTER PROCEDURE [Inventory].[AgregarDetalleInvEqTec]
		@idEquipo INT, @idInventario INT
		AS
		BEGIN 
			INSERT INTO Detalle_Inv_EqTecnologico(Detalle_Inv_EqTecnologico.idInventario,
						Detalle_Inv_EqTecnologico.idEquipoTecnologico)
			VALUES(@idInventario,@idEquipo)
		END;
Go
-- FUNCTION: Obtener Id del equipo tecnologico
		CREATE OR ALTER FUNCTION [Inventory].[ObtenerIdEquipo]
		(
			@numArt int
		)
		RETURNS INT
		AS
		BEGIN
			DECLARE @idEquipoTecnologico INT;
    
			SELECT @idEquipoTecnologico = idEquipoTecnologico
			FROM EquipoTecnologico
			WHERE numeroArt = @numArt;
    
			RETURN @idEquipoTecnologico;
		END;
Go
-- FUNCTION: Obtener Id del numero de  inventario
		CREATE OR ALTER FUNCTION [Inventory].[ObteneridInventario]
		(
			@numInventrio int
		)
		RETURNS INT
		AS
		BEGIN
			DECLARE @idInventario INT;
    
			SELECT @idInventario = idInventario
			FROM Inventario
			WHERE NumInventario = @numInventrio;
    
			RETURN @idInventario;
		END;
Go


/******************* Detalle de inventario de equipo mobiliario *************************/
-- PROCEDURE: AGREGAR
		CREATE OR ALTER PROCEDURE [Inventory].[AgregarDetalleInvEqMob]
		 @idEquipo INT, @idInventario INT
		AS
		BEGIN 
		INSERT INTO Detalle_Inv_EqMobiliario(Detalle_Inv_EqMobiliario.idInventario,
					Detalle_Inv_EqMobiliario.idEquipoMobiliario)
		VALUES(@idInventario,@idEquipo)
		END;
Go
-- FUNCTION: Obtener Id del equipo mobiliario
		CREATE OR ALTER FUNCTION [Inventory].[ObtenerIdEquipoMob]
		(
			@numArt int
		)
		RETURNS INT
		AS
		BEGIN
			DECLARE @idEquipoMobiliario INT;
    
			SELECT @idEquipoMobiliario = idEquipoMobiliario
			FROM EquipoMobiliario
			WHERE numeroArticulo = @numArt;
    
			RETURN @idEquipoMobiliario;
		END;
Go
	
/******************* Movimiento *************************/
--PROCEDURE: AGREGAR
		CREATE OR ALTER PROCEDURE [Inventory].[GuardarMovimientos]
		@noMovimiento INT,
		@responsableInss INT,
		@idLab INT,
		@idTipoMov INT,
		@fecha DATE,
		@LocacionNueva VARCHAR (150),
		@Observacion VARCHAR (150)
		AS
		BEGIN
		INSERT INTO Movimiento(noMovimiento,inss,idLab,idTpMovimiento,Fecha
								,LocacionNueva,Observacion)

		VALUES (@noMovimiento,@responsableInss,@idLab,@idTipoMov,@fecha,@LocacionNueva,@Observacion)
		END
GO
-- VIEW: Total  de movimiento 
		CREATE OR ALTER VIEW [Inventory].[MovimientosView]
		AS
		SELECT COUNT(*) as  Total FROM Movimiento
Go

-- VIEW: Listar tipo de movimiento cmb
		CREATE OR ALTER VIEW [Inventory].[TipoMovimientoView]
		AS
		SELECT tipoMovimiento
		FROM Tipo_Movimiento
Go
-- FUNCTION: Obtener Id de lab
		CREATE OR ALTER FUNCTION [Inventory].[ObtenerIdLab]
		(
			@lab VARCHAR(50)
		)
		RETURNS INT
		AS
		BEGIN
			DECLARE @idLab INT;
    
			SELECT @idLab = idLab
			FROM Laboratorio
			WHERE numeroLab = @lab;
    
			RETURN @idLab;
		END;
Go
-- FUNCTION: Obtener Id de tipo de movimiento
		CREATE OR ALTER FUNCTION [Inventory].[ObtenerIdTipoMovimient]
		(
			@tpMov VARCHAR(50)
		)
		RETURNS INT
		AS
		BEGIN
			DECLARE @idtpMov INT;
    
			SELECT @idtpMov = idTipoMovimiento
			FROM Tipo_Movimiento
			WHERE tipoMovimiento = @tpMov;
    
			RETURN @idtpMov;
		END;
Go
-- VIEW: Equipos tecnologicos que asignados
			CREATE OR ALTER PROCEDURE [Inventory].[EquipoTecnologicoAsignados]
			@numArt int
			AS
			BEGIN
			select DISTINCT Eq.numeroArt, L.numeroLab from EquipoTecnologico as Eq
			inner join detalleMovEqTec as D on D.idEquipoTecnologico = Eq.idEquipoTecnologico
			inner join Movimiento as M on M.noMovimiento = D.noMovmiento
			inner join Laboratorio as L on L.idLab = M.idLab
			WHERE eq.numeroArt = @numArt
			END;
Go
-- VIEW: Equipos tecnologicos que asignados
			CREATE OR ALTER PROCEDURE [Inventory].[EquipoMobiliarioAsignados]
			@numArt int
			AS
			BEGIN
			select DISTINCT Eq.numeroArticulo, L.numeroLab from EquipoMobiliario as Eq
			inner join detalleMovEqMob as D on D.idEquipoMobiliario = Eq.idEquipoMobiliario
			inner join Movimiento as M on M.noMovimiento = D.noMovmiento
			inner join Laboratorio as L on L.idLab = M.idLab
			WHERE eq.numeroArticulo = @numArt
			END;
Go
-- PROCEDURE: Listar Movimientos Equipo tecnologicos
		CREATE OR ALTER PROCEDURE [Inventory].[ListarMovimientosTec]
		AS
		BEGIN
			SELECT M.noMovimiento, EqTec.numeroArt,EqTec.descripcion , M.Fecha, T.tipoMovimiento, LocacionNueva as LocacioNueva,L.numeroLab
			FROM detalleMovEqTec as  Eq
			INNER JOIN Movimiento as M on M.noMovimiento = Eq.noMovmiento
			INNER JOIN EquipoTecnologico as EqTec on EqTec.idEquipoTecnologico = Eq.idEquipoTecnologico
			INNER JOIN Laboratorio as L on L.idLab = M.idLab	
			INNER JOIN Tipo_Movimiento as T on T.idTipoMovimiento = M.idTpMovimiento
	
		END;
Go
-- PROCEDURE: Listar movimientos en un equipo tecnologicos
		CREATE OR ALTER PROCEDURE [Inventory].[ListarMovimientosEquipoTec]
		@numArt int
		AS
		BEGIN
				SELECT M.noMovimiento, EqTec.numeroArt, EqTec.descripcion,T.tipoMovimiento, M.Fecha, M.LocacionNueva , L.numeroLab
		FROM detalleMovEqTec as Eq
		INNER JOIN Movimiento as M ON M.noMovimiento = Eq.noMovmiento
		INNER JOIN EquipoTecnologico as EqTec ON EqTec.idEquipoTecnologico = Eq.idEquipoTecnologico
		INNER JOIN Laboratorio as L ON L.idLab = M.idLab
		INNER JOIN Tipo_Movimiento as T on T.idTipoMovimiento = M.idTpMovimiento
		WHERE EqTec.numeroArt = @numArt
		END;
Go-- Reportes

--VIEW: Buscar		
		CREATE OR ALTER VIEW [Inventory].[MovimientoBuscarEqTecView]
		AS
		SELECT M.noMovimiento, R.nombres + ' ' + R.apellidos AS Responsable ,TM.tipoMovimiento, Eq.numeroArt,Eq.descripcion
		, L.numeroLab, M.LocacionNueva,M.Observacion, M.Fecha
		FROM Movimiento AS M
		inner JOIN Responsable AS R ON R.inss = M.inss
		INNER JOIN Tipo_Movimiento AS TM ON TM.idTipoMovimiento = M.idTpMovimiento
		INNER JOIN detalleMovEqTec as D on D.noMovmiento = M.noMovimiento
		INNER JOIN EquipoTecnologico AS Eq on Eq.idEquipoTecnologico = D.idEquipoTecnologico
		INNER JOIN Laboratorio as L on L.idLab = M.idLab
Go
--VIEW: Buscar		
		CREATE OR ALTER VIEW [Inventory].[MovimientoBuscarEqMobView]
		AS
		SELECT M.noMovimiento, R.nombres + ' ' + R.apellidos AS Responsable ,TM.tipoMovimiento, Eq.numeroArticulo,Eq.descripcion
		, L.numeroLab, M.LocacionNueva,M.Observacion, M.Fecha
		FROM Movimiento AS M
		inner JOIN Responsable AS R ON R.inss = M.inss
		INNER JOIN Tipo_Movimiento AS TM ON TM.idTipoMovimiento = M.idTpMovimiento
		INNER JOIN detalleMovEqMob as D on D.noMovmiento = M.noMovimiento
		INNER JOIN EquipoMobiliario AS Eq on Eq.idEquipoMobiliario = D.idEquipoMobiliario
		INNER JOIN Laboratorio as L on L.idLab = M.idLab
Go
-- PROCEDURE: Listar Movimientos Equipo mobiliarios
		CREATE OR ALTER PROCEDURE [Inventory].[ListarMovimientosMob]
		AS
		BEGIN
			SELECT M.noMovimiento, EqMob.numeroArticulo,EqMob.descripcion , M.Fecha,T.tipoMovimiento ,M.LocacionNueva as LocacioNueva,L.numeroLab
			FROM detalleMovEqMob as  Eq
			INNER JOIN Movimiento as M on M.noMovimiento = Eq.noMovmiento
			INNER JOIN EquipoMobiliario as EqMob on EqMob.idEquipoMobiliario = Eq.idEquipoMobiliario
			INNER JOIN Laboratorio as L on L.idLab = M.idLab
			INNER JOIN Tipo_Movimiento as T on T.idTipoMovimiento = M.idTpMovimiento
		END;
Go
-- PROCEDURE: Listar movimientos en un equipo tecnologicos
		CREATE OR ALTER PROCEDURE [Inventory].[ListarMovimientosEquipoMob]
		@numArt int
		AS
		BEGIN
				SELECT M.noMovimiento, EqMob.numeroArticulo, EqMob.descripcion, M.Fecha,T.tipoMovimiento,M.LocacionNueva , L.numeroLab
		FROM detalleMovEqMob as Eq
		INNER JOIN Movimiento as M ON M.noMovimiento = Eq.noMovmiento
		INNER JOIN EquipoMobiliario as EqMob ON EqMob.idEquipoMobiliario = Eq.idEquipoMobiliario
		INNER JOIN Laboratorio as L ON L.idLab = M.idLab
		INNER JOIN Tipo_Movimiento as T on T.idTipoMovimiento = M.idTpMovimiento
		WHERE EqMob.numeroArticulo = @numArt
		END;
Go
/******************* Detalle Movimiento de equipo tecnológico *************************/
--PROCEDURE: AGREGAR
		CREATE OR ALTER PROCEDURE [Inventory].[GuardarDetalleMovTec]
		@noMovimiento INT,
		@idEquipoTecnologico INT
	AS
	BEGIN
		INSERT INTO detalleMovEqTec (noMovmiento,idEquipoTecnologico)
		VALUES (@noMovimiento,@idEquipoTecnologico)
		END;
GO

/******************* Detalle Movimiento de equipo mobiliario *************************/
--PROCEDURE: AGREGAR
		CREATE OR ALTER PROCEDURE [Inventory].[GuardarDetalleMovMob]
		@noMovimiento INT,
		@idEquipoMobiliario INT
	AS
	BEGIN

		INSERT INTO detalleMovEqMob(noMovmiento,idEquipoMobiliario)
		VALUES (@noMovimiento,@idEquipoMobiliario)
		END
GO

/***************Laboratorio*******************/
--PROCEDURE: GUARDAR
	CREATE OR ALTER PROCEDURE [Inventory].[GuardarLaboratorio]
		@numeroLab Varchar (100),
		@Estado Varchar (100)
	AS
	BEGIN

		INSERT INTO Laboratorio(numeroLab,Estado)
		VALUES (@numeroLab,@Estado)
		END
GO
-- VIEW: Listar Laboratorios cmb
		CREATE OR ALTER VIEW [Inventory].[LaboratorioView]
		AS
		SELECT numeroLab
		FROM Laboratorio
Go
-- PROCEDURE: Listar equipos tecnologicos  en LAB
		CREATE OR ALTER PROCEDURE [Inventory].[LaboratorioEquipoTecView]		
		@idlAB INT
		AS
		SELECT Eq.numeroArt, Eq.descripcion,MR.marca, Eq.modelo, E.estado, Eq.observacion
		FROM EquipoTecnologico AS Eq
		INNER JOIN detalleMovEqTec AS D ON D.idEquipoTecnologico = Eq.idEquipoTecnologico 
		inner join Movimiento as M  on M.noMovimiento = D.noMovmiento
		INNER JOIN Laboratorio AS L ON L.idLab = M.idLab
		INNER JOIN MarcaEquipo AS MR ON MR.idMarca = Eq.idMarca
		INNER JOIN Estado AS E on E.idEstado = Eq.idMarca
		WHERE  L.idLab = @idlAB
		
Go
-- PROCEDURE: Listar equipos mobiliario  en LAB
		CREATE OR ALTER PROCEDURE [Inventory].[LaboratorioEquipoMobView]
		@idLab int
		AS
		SELECT Eq.numeroArticulo, Eq.descripcion, E.estado, Eq.observacion
		FROM EquipoMobiliario AS Eq
		INNER JOIN detalleMovEqMob AS D ON D.idEquipoMobiliario = Eq.idEquipoMobiliario
		inner join Movimiento as M  on M.noMovimiento = D.noMovmiento
		INNER JOIN Laboratorio AS L ON L.idLab = M.idLab
		INNER JOIN Estado AS E on E.idEstado = Eq.idEstado
		WHERE L.idLab = @idLab	
Go
-- PROCEDURE: BORRAR LABORATORIO
		CREATE OR ALTER PROCEDURE [Inventory].[BorrarLaboratorio]
		@numeroLab Varchar (100)
	AS
	BEGIN

		DELETE from Laboratorio
			WHERE numeroLab = @numeroLab
		END
GO
-- PROCEDURE: Guardar Encargado del Laboratorio
	CREATE OR ALTER PROCEDURE [Inventory].[GuardarEncargadoLab]
		@idLab INT,
		@noCarnet INT,
		@fechaEntrada DATE,
		@fechaSalida DATE
	AS
	BEGIN

		INSERT INTO EncargadoLlab (idLab,noCarnet,fechaEntrada,fechaSalida)
		VALUES (@idLab,@noCarnet,@fechaEntrada,@fechaSalida)
		END
GO
-- PROCEDURE: Actualizar Encargado del Laboratorio
	CREATE OR ALTER PROCEDURE [Inventory].[ActualizarEncargadoLab]
		@idLab INT,
		@noCarnet INT,
		@fechaEntrada DATE,
		@fechaSalida DATE
	AS
	BEGIN
		UPDATE EncargadoLlab
			SET noCarnet = @noCarnet,
			fechaEntrada = @fechaEntrada, fechaSalida = @fechaSalida
		WHERE idLab = @idLab
	END
Go
-- VIEW: para laboratorios
	CREATE OR ALTER VIEW [Inventory].[EncargadosView]
		AS
		SELECT L.numeroLab, I.nombres + ' ' + I.apellidos AS Instructor ,E.fechaEntrada, E.fechaSalida from EncargadoLlab as E
		INNER JOIN Laboratorio as L on L.idLab = E.idLab
		INNER JOIN Instructor as I on I.noCarnet = E.noCarnet 
Go
-- PROCEDURE: listar
		CREATE OR ALTER PROCEDURE [Inventory].[EncargadosListar]
		AS
		BEGIN
		SELECT L.numeroLab,  I.nombres + ' ' + I.apellidos AS Instructor,I.noCarnet, E.fechaEntrada, E.fechaSalida from EncargadoLlab as E
		INNER JOIN Laboratorio as L on L.idLab = E.idLab
		INNER JOIN Instructor as I on I.noCarnet = E.noCarnet 
		END
Go
/*****************Facultad*****************/
-- VIEW: Listar marca cmb
		CREATE OR ALTER VIEW [Inventory].[FacultadView]
		AS
		SELECT Facultdad
		FROM Facultad
Go
/*****************Dependencia*****************/
-- VIEW: Listar marca cmb
		CREATE OR ALTER VIEW [Inventory].[DependenciaView]
		AS
		SELECT Departamento
		FROM Dependencia
Go
/*****************Recinto*****************/
-- VIEW: Listar marca cmb
		CREATE OR ALTER VIEW [Inventory].[RecintoView]
		AS
		SELECT Recinto
		FROM Recinto
Go
/*****************Login*****************/
-- FUNCTION: Verificar registro de responsable
		CREATE OR ALTER PROCEDURE [Inventory].[LoginResponsable]
		(
			@contrasenia VARCHAR(30),
			@inss INT
		)
		AS
		BEGIN
		(
			SELECT
				COUNT(*) AS [Count],
				MAX(RES.nombres + ' ' + RES.apellidos) AS [Nombre]
			FROM
				usuario_r AS R
				INNER JOIN Responsable AS RES ON RES.inss = R.inss
			WHERE
				R.inss = @inss
				AND R.contrasenia = @contrasenia
		)
		END;
Go
-- FUNCTION: Verificar registro de instructor
		CREATE OR ALTER PROCEDURE [Inventory].[LoginInstructor]
		(
			@contrasenia VARCHAR(30),
			@inss INT
		)
		AS
		BEGIN
		(
			SELECT
				COUNT(*) AS [Count],
				MAX(INS.nombres + ' ' + INS.apellidos) AS [Nombre]
			FROM
				usuario_I AS i
				INNER JOIN Instructor AS INS ON INS.noCarnet = i.noCarnet
			WHERE
				i.noCarnet = @inss
				AND i.contrasenia = @contrasenia
		)
		END;
Go
