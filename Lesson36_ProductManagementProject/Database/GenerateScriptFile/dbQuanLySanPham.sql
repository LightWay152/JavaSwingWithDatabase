USE [master]
GO
/****** Object:  Database [dbQuanLySanPham]    Script Date: 10-Apr-17 7:01:41 AM ******/
CREATE DATABASE [dbQuanLySanPham]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'dbQuanLySanPham', FILENAME = N'E:\WorkSpace\JEE\Lesson36_ProductManagementProject\Database\dbQuanLySanPham.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'dbQuanLySanPham_log', FILENAME = N'E:\WorkSpace\JEE\Lesson36_ProductManagementProject\Database\dbQuanLySanPham_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [dbQuanLySanPham] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [dbQuanLySanPham].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [dbQuanLySanPham] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET ARITHABORT OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [dbQuanLySanPham] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [dbQuanLySanPham] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET  DISABLE_BROKER 
GO
ALTER DATABASE [dbQuanLySanPham] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [dbQuanLySanPham] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [dbQuanLySanPham] SET  MULTI_USER 
GO
ALTER DATABASE [dbQuanLySanPham] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [dbQuanLySanPham] SET DB_CHAINING OFF 
GO
ALTER DATABASE [dbQuanLySanPham] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [dbQuanLySanPham] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [dbQuanLySanPham] SET DELAYED_DURABILITY = DISABLED 
GO
USE [dbQuanLySanPham]
GO
/****** Object:  Table [dbo].[DanhMuc]    Script Date: 10-Apr-17 7:01:41 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMuc](
	[MaDM] [nvarchar](50) NOT NULL,
	[TenDM] [nvarchar](250) NULL,
	[IsDeleted] [int] NULL,
 CONSTRAINT [PK_DanhMuc] PRIMARY KEY CLUSTERED 
(
	[MaDM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 10-Apr-17 7:01:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSp] [nvarchar](50) NOT NULL,
	[TenSP] [nvarchar](250) NULL,
	[SoLuong] [int] NULL,
	[DonGia] [int] NULL,
	[MADM] [nvarchar](50) NULL,
	[IsDeleted] [int] NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[MaSp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM], [IsDeleted]) VALUES (N'dm1', N'Hàng Điện Tử', 0)
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM], [IsDeleted]) VALUES (N'dm2', N'Hàng Hóa Chất', 0)
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM], [IsDeleted]) VALUES (N'dm3', N'Hàng Gia Dụng', 0)
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM], [IsDeleted]) VALUES (N'dm4', N'Hàng Dễ Vỡ', 1)
INSERT [dbo].[SanPham] ([MaSp], [TenSP], [SoLuong], [DonGia], [MADM], [IsDeleted]) VALUES (N'sp1', N'Bóng đèn Aladanh', 100, 20, N'dm1', 0)
INSERT [dbo].[SanPham] ([MaSp], [TenSP], [SoLuong], [DonGia], [MADM], [IsDeleted]) VALUES (N'sp115', N'Bếp Điện Từ', 100, 25, N'dm3', 0)
INSERT [dbo].[SanPham] ([MaSp], [TenSP], [SoLuong], [DonGia], [MADM], [IsDeleted]) VALUES (N'sp2', N'Máy Phát điện', 40, 10, N'dm2', 0)
INSERT [dbo].[SanPham] ([MaSp], [TenSP], [SoLuong], [DonGia], [MADM], [IsDeleted]) VALUES (N'sp3', N'Chảo Không Dính', 500, 35, N'dm3', 0)
INSERT [dbo].[SanPham] ([MaSp], [TenSP], [SoLuong], [DonGia], [MADM], [IsDeleted]) VALUES (N'sp4', N'Nồi nấu Lẩu', 200, 14, N'dm3', 0)
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_DanhMuc] FOREIGN KEY([MADM])
REFERENCES [dbo].[DanhMuc] ([MaDM])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_DanhMuc]
GO
USE [master]
GO
ALTER DATABASE [dbQuanLySanPham] SET  READ_WRITE 
GO
