USE [master]
GO

/****** Object:  Database [ChiTieu]    Script Date: 3/21/2022 10:45:33 PM ******/
CREATE DATABASE [ChiTieu]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ChiTieu', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLCSD\MSSQL\DATA\ChiTieu.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ChiTieu_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLCSD\MSSQL\DATA\ChiTieu_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ChiTieu].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [ChiTieu] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [ChiTieu] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [ChiTieu] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [ChiTieu] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [ChiTieu] SET ARITHABORT OFF 
GO

ALTER DATABASE [ChiTieu] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [ChiTieu] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [ChiTieu] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [ChiTieu] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [ChiTieu] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [ChiTieu] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [ChiTieu] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [ChiTieu] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [ChiTieu] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [ChiTieu] SET  DISABLE_BROKER 
GO

ALTER DATABASE [ChiTieu] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [ChiTieu] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [ChiTieu] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [ChiTieu] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [ChiTieu] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [ChiTieu] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [ChiTieu] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [ChiTieu] SET RECOVERY FULL 
GO

ALTER DATABASE [ChiTieu] SET  MULTI_USER 
GO

ALTER DATABASE [ChiTieu] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [ChiTieu] SET DB_CHAINING OFF 
GO

ALTER DATABASE [ChiTieu] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [ChiTieu] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO

ALTER DATABASE [ChiTieu] SET DELAYED_DURABILITY = DISABLED 
GO

ALTER DATABASE [ChiTieu] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO

ALTER DATABASE [ChiTieu] SET QUERY_STORE = OFF
GO

ALTER DATABASE [ChiTieu] SET  READ_WRITE 
GO


