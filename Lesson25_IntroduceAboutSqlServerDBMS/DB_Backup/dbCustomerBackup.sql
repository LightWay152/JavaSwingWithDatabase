USE [master]
GO
/****** Object:  Database [dbCustomer]    Script Date: 26-Mar-17 5:04:14 PM ******/
CREATE DATABASE [dbCustomer]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'dbCustomer', FILENAME = N'E:\WorkSpace\JEE\Lesson25_IntroduceAboutSqlServerDBMS\SourceCode\DB\dbCustomer.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'dbCustomer_log', FILENAME = N'E:\WorkSpace\JEE\Lesson25_IntroduceAboutSqlServerDBMS\SourceCode\DB\dbCustomer_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [dbCustomer] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [dbCustomer].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [dbCustomer] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [dbCustomer] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [dbCustomer] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [dbCustomer] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [dbCustomer] SET ARITHABORT OFF 
GO
ALTER DATABASE [dbCustomer] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [dbCustomer] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [dbCustomer] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [dbCustomer] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [dbCustomer] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [dbCustomer] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [dbCustomer] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [dbCustomer] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [dbCustomer] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [dbCustomer] SET  DISABLE_BROKER 
GO
ALTER DATABASE [dbCustomer] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [dbCustomer] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [dbCustomer] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [dbCustomer] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [dbCustomer] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [dbCustomer] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [dbCustomer] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [dbCustomer] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [dbCustomer] SET  MULTI_USER 
GO
ALTER DATABASE [dbCustomer] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [dbCustomer] SET DB_CHAINING OFF 
GO
ALTER DATABASE [dbCustomer] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [dbCustomer] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [dbCustomer] SET DELAYED_DURABILITY = DISABLED 
GO
USE [dbCustomer]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 26-Mar-17 5:04:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[CustomerID] [nvarchar](50) NOT NULL,
	[CustomerName] [nvarchar](250) NULL,
	[YOB] [datetime] NULL,
	[GroupID] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CustomerGroup]    Script Date: 26-Mar-17 5:04:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CustomerGroup](
	[GroupId] [nvarchar](50) NOT NULL,
	[GroupName] [nvarchar](250) NULL,
 CONSTRAINT [PK_CustomerGroup] PRIMARY KEY CLUSTERED 
(
	[GroupId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Customer] ([CustomerID], [CustomerName], [YOB], [GroupID]) VALUES (N'cus1', N'Tây Độc', CAST(N'1905-06-14 00:00:00.000' AS DateTime), N'cusGroup3')
INSERT [dbo].[Customer] ([CustomerID], [CustomerName], [YOB], [GroupID]) VALUES (N'cus2', N'Đông Tà', CAST(N'1905-06-16 00:00:00.000' AS DateTime), N'cusGroup1')
INSERT [dbo].[Customer] ([CustomerID], [CustomerName], [YOB], [GroupID]) VALUES (N'cus3', N'Chu Bá Thông', CAST(N'1905-06-19 00:00:00.000' AS DateTime), N'cusGroup3')
INSERT [dbo].[CustomerGroup] ([GroupId], [GroupName]) VALUES (N'cusGroup1', N'VIP Customer')
INSERT [dbo].[CustomerGroup] ([GroupId], [GroupName]) VALUES (N'cusGroup2', N'Việt Nam Customer')
INSERT [dbo].[CustomerGroup] ([GroupId], [GroupName]) VALUES (N'cusGroup3', N'Prissy Customer')
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [FK_Customer_CustomerGroup] FOREIGN KEY([GroupID])
REFERENCES [dbo].[CustomerGroup] ([GroupId])
GO
ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [FK_Customer_CustomerGroup]
GO
/****** Object:  StoredProcedure [dbo].[GetAllCustomer]    Script Date: 26-Mar-17 5:04:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[GetAllCustomer]
as
select * from Customer
GO
/****** Object:  StoredProcedure [dbo].[GetCustomerByGroup]    Script Date: 26-Mar-17 5:04:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[GetCustomerByGroup]
@GroupId nvarchar(50)
as
select * from Customer where GroupId=@GroupId
GO
USE [master]
GO
ALTER DATABASE [dbCustomer] SET  READ_WRITE 
GO
