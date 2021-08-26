-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 26, 2021 at 12:51 PM
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
-- Database: `inventorysystem`
--

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `addBuy`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addBuy` (IN `staffIn` INT, IN `productIn` INT, IN `supplierIn` INT, IN `quantityIn` INT, IN `priceIn` DOUBLE)  INSERT buy (`staffID`, `productID`, `supplierID`, `quantity`, `price`, `date`)
VALUES
(staffIn,productIn,supplierIn,quantityIn,priceIn, NOW())$$

DROP PROCEDURE IF EXISTS `addSell`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSell` (IN `staffIn` INT(11), IN `productIn` INT(11), IN `customerIn` INT(11), IN `quantityIn` INT(11), IN `priceIn` DOUBLE)  INSERT sell (`staffID`, `productID`, `customerID`, `quantity`, `price`, `date`)
VALUES
(staffIn,productIn,customerIn,quantityIn,priceIn, NOW())$$

DROP PROCEDURE IF EXISTS `getBuyNumber`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getBuyNumber` ()  SELECT COUNT(*)
FROM buy$$

DROP PROCEDURE IF EXISTS `getCategoryNumber`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCategoryNumber` ()  SELECT COUNT(*)
FROM category$$

DROP PROCEDURE IF EXISTS `getCustomerNumber`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCustomerNumber` ()  SELECT COUNT(*)
FROM customer$$

DROP PROCEDURE IF EXISTS `getProductNumber`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getProductNumber` ()  READS SQL DATA
SELECT COUNT(*)
FROM product$$

DROP PROCEDURE IF EXISTS `getSellNumber`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSellNumber` ()  READS SQL DATA
SELECT COUNT(*)
FROM sell$$

DROP PROCEDURE IF EXISTS `getStaffNumber`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStaffNumber` ()  READS SQL DATA
SELECT COUNT(*)
FROM staff$$

DROP PROCEDURE IF EXISTS `getStorageNumber`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStorageNumber` ()  READS SQL DATA
SELECT COUNT(*)
FROM storage$$

DROP PROCEDURE IF EXISTS `getSupplierNumber`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSupplierNumber` ()  SELECT COUNT(*)
FROM supplier$$

DROP PROCEDURE IF EXISTS `updateBuy`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateBuy` (IN `productIn` INT(11), IN `quantity` DOUBLE)  UPDATE product SET productQuantity = (productQuantity + quantityIn) WHERE productID = productIn$$

DROP PROCEDURE IF EXISTS `updateSell`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSell` (IN `productIn` INT(11), IN `quantity` DOUBLE)  UPDATE product SET productQuantity = (productQuantity - quantityIn) WHERE productID = productIn$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `buy`
--

DROP TABLE IF EXISTS `buy`;
CREATE TABLE IF NOT EXISTS `buy` (
  `BuyID` int(11) NOT NULL AUTO_INCREMENT,
  `staffID` int(11) NOT NULL,
  `supplierID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`BuyID`),
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
  `customerAddress` varchar(40) NOT NULL,
  `customerEmail` varchar(40) NOT NULL,
  PRIMARY KEY (`customerID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Fname`, `Lname`, `customerID`, `customerPhone`, `customerAddress`, `customerEmail`) VALUES
('hello', 'world', 1, '1222', 'pc', 'pc@some.com'),
('Clark', 'Kent', 2, '12122', 'Kryptonopolis', 'superman@justiceleague.com'),
('Oliver', 'Queen', 3, '34533', 'Starling City', 'arrow@justiceleague.com'),
('Barry', 'Allen', 4, '4722', 'Central City', 'flash@justiceleague.com');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `productName` varchar(30) NOT NULL,
  `productID` int(11) NOT NULL AUTO_INCREMENT,
  `productPrice` double NOT NULL,
  `importDate` date NOT NULL,
  `productDescription` varchar(50) NOT NULL,
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
  `Sell_ID` int(11) NOT NULL,
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
  `staffAddress` varchar(40) NOT NULL,
  `staffPhone` char(13) NOT NULL,
  `staffEmail` varchar(40) NOT NULL,
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
  `supplierName` varchar(30) NOT NULL,
  `supplierAddress` varchar(40) NOT NULL,
  `supplierPhone` varchar(13) NOT NULL,
  `supplierEmail` varchar(40) NOT NULL,
  `POBOX` int(11) NOT NULL,
  `supplierDescription` varchar(50) NOT NULL,
  PRIMARY KEY (`supplierID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supplierID`, `supplierName`, `supplierAddress`, `supplierPhone`, `supplierEmail`, `POBOX`, `supplierDescription`) VALUES
(1, 'Loki Laufeyson', 'Asgard', '12312', 'loki@avengers.com', 965, 'Brother of Thor');

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
