-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 14, 2022 at 05:05 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `komputer`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerId` int(20) NOT NULL,
  `PembelianNo` int(112) NOT NULL,
  `Jumlah` int(11) NOT NULL,
  `Total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `ItemId` int(50) NOT NULL,
  `Nama` varchar(80) NOT NULL,
  `Jumlah` int(100) NOT NULL,
  `Harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`ItemId`, `Nama`, `Jumlah`, `Harga`) VALUES
(10, 'Headphone gaming', 1, 400000),
(12, 'USB', 50, 20000),
(22, 'red', 12, 12),
(40, 'Kursi', 5, 1870000),
(80, 'Kursi', 5, 1870000),
(99, 'dsdasdas', 34, 23432),
(122, 'tuyu', 44, 44),
(133, 'gkjk', 56, 99),
(199, 'khgkj', 12, 12),
(554, 'hjgkhg', 4545, 455),
(997, 'gg', 23, 12321),
(1222, 'Keyboard', 1, 500000),
(1226, 'Meja', 3, 1500000),
(1233, 'Mousepad', 1, 10000),
(1238, 'mic', 12, 22222),
(1344, 'Keycabs', 60, 5000),
(2227, 'Mining rig', 4, 60000000),
(2344, '	cpu', 15, 2500000),
(2447, 'Usb mining', 4, 2000000),
(4660, 'hhh', 1232, 20),
(5324, 're', 22, 12),
(5432, 'jgfjfgh', 23, 666),
(5433, 'hkjkhj', 8899, 89899),
(5555, 'we', 12, 12233),
(5633, 'gwss', 45, 353),
(5656, 'sds', 23, 23423),
(6666, 'HGKGKG', 12, 90),
(6677, 'hgkjh', 89, 990),
(7656, 'Kabel', 2, 20000),
(8887, 'ytyghkjgkj', 12, 78),
(8888, 'jgfjgjgj', 7878, 6767),
(8997, 'hgkgjkh', 79, 88),
(9764, '7767', 55, 66),
(9865, 'HJVJVJ', 45, 34),
(12225, 'ggg', 22, 7777),
(12226, 'USB male', 50, 25000),
(12227, 'USB female', 50, 25000);

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `PembelianNo` int(11) NOT NULL,
  `ItemId` int(11) NOT NULL,
  `Jumlah` int(11) NOT NULL,
  `Harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`PembelianNo`, `ItemId`, `Jumlah`, `Harga`) VALUES
(99, 99, 3, 34),
(99, 99, 99, 34),
(1, 99, 1000, 1),
(1, 99, 7788, 677),
(5, 99, 88, 78787),
(2, 1111, 212, 788),
(34, 1111, 2, 23),
(1, 12, 2123, 3223),
(8, 99, 121, 32423423423),
(8, 12225, 121, 32423423423),
(8, 12225, 121, 32423423423),
(2, 99, 3, 22),
(3, 23, 23, 343224),
(6, 111, 23, 2342),
(111, 12, 13, 321),
(111, 6656, 7576, 787878),
(111, 889, 7576, 787878),
(111, 1238, 7576, 787878),
(111, 99, 2, 34),
(111, 99, 34, 34),
(1111, 1111, 9, 99),
(1111, 99, 9, 99),
(1111, 1111, 4, 23),
(1111, 1111, 6, 23),
(1111, 99, 3, 20000),
(1111, 99, 3, 20000),
(1111, 99, 3, 20000),
(1111, 1111, 2, 40000),
(1111, 99, 2, 34),
(99, 99, 3, 30000),
(99, 1222, 2, 400000),
(99, 1111, 3, 25000),
(99, 1111, 3, 20000),
(99, 1111, 2, 4000),
(22, 22, 2, 20000),
(22, 133, 2, 200000),
(11, 22, 2, 20000),
(11, 122, 2, 20000),
(12, 12, 3, 20000),
(12, 40, 3, 20000),
(12, 12227, 3, 20000),
(878, 12, 2, 20000),
(878, 40, 2, 1870000),
(878, 12, 3, 20000),
(12, 12, 2, 20000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerId`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`ItemId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CustomerId` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `ItemId` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23432433;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
