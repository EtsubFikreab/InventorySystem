-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 21, 2021 at 12:01 AM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `buy`
--

DROP TABLE IF EXISTS `buy`;
CREATE TABLE IF NOT EXISTS `buy` (
  `staffID` int(11) NOT NULL,
  `supplierID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `date` date NOT NULL,
  KEY `staffID` (`staffID`),
  KEY `supplierID` (`supplierID`),
  KEY `productID` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `categoryName` varchar(15) NOT NULL,
  `categoryID` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(30) NOT NULL,
  PRIMARY KEY (`categoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `Fname` varchar(15) NOT NULL,
  `Lname` varchar(15) NOT NULL,
  `customerID` int(11) NOT NULL AUTO_INCREMENT,
  `customerPhone` char(13) NOT NULL,
  `customerAddress` varchar(15) NOT NULL,
  `customerEmail` varchar(15) NOT NULL,
  PRIMARY KEY (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `productName` varchar(15) NOT NULL,
  `productID` int(11) NOT NULL AUTO_INCREMENT,
  `productPrice` double NOT NULL,
  `importDate` date NOT NULL,
  `productDescription` varchar(30) NOT NULL,
  `productQuantity` int(11) NOT NULL,
  `catagoryID` int(11) NOT NULL,
  `storageID` int(11) NOT NULL,
  PRIMARY KEY (`productID`),
  KEY `catalogID` (`catagoryID`),
  KEY `storageID` (`storageID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sell`
--

DROP TABLE IF EXISTS `sell`;
CREATE TABLE IF NOT EXISTS `sell` (
  `staffID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `customerID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `date` date NOT NULL,
  KEY `staffID` (`staffID`),
  KEY `productID` (`productID`),
  KEY `catalogID` (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE IF NOT EXISTS `staff` (
  `Fname` varchar(15) NOT NULL,
  `Lname` varchar(15) NOT NULL,
  `staffID` int(11) NOT NULL AUTO_INCREMENT,
  `staffAddress` varchar(15) NOT NULL,
  `staffPhone` char(13) NOT NULL,
  `staffEmail` varchar(30) NOT NULL,
  PRIMARY KEY (`staffID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `storage`
--

DROP TABLE IF EXISTS `storage`;
CREATE TABLE IF NOT EXISTS `storage` (
  `storageArea` varchar(20) NOT NULL,
  `storageID` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`storageID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE IF NOT EXISTS `supplier` (
  `supplierID` int(11) NOT NULL AUTO_INCREMENT,
  `supplierName` varchar(15) NOT NULL,
  `supplierAddress` varchar(15) NOT NULL,
  `supplierPhone` char(13) NOT NULL,
  `supplierEmail` varchar(15) NOT NULL,
  `POBOX` int(11) NOT NULL,
  `supplierDescription` varchar(30) NOT NULL,
  PRIMARY KEY (`supplierID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `buy`
--
ALTER TABLE `buy`
  ADD CONSTRAINT `buy_ibfk_1` FOREIGN KEY (`staffID`) REFERENCES `staff` (`staffID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `buy_ibfk_2` FOREIGN KEY (`supplierID`) REFERENCES `supplier` (`supplierID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `buy_ibfk_3` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`catagoryID`) REFERENCES `category` (`categoryID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `product_ibfk_2` FOREIGN KEY (`storageID`) REFERENCES `storage` (`storageID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `sell`
--
ALTER TABLE `sell`
  ADD CONSTRAINT `sell_ibfk_2` FOREIGN KEY (`staffID`) REFERENCES `staff` (`staffID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sell_ibfk_3` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sell_ibfk_4` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
