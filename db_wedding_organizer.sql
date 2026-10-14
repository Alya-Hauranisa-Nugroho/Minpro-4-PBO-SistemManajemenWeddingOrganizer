-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 14, 2026 at 06:25 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_wedding_organizer`
--

-- --------------------------------------------------------

--
-- Table structure for table `paket_wedding`
--

CREATE TABLE `paket_wedding` (
  `id_paket` int NOT NULL,
  `nama_paket` varchar(100) NOT NULL,
  `harga` int NOT NULL
) ;

--
-- Dumping data for table `paket_wedding`
--

INSERT INTO `paket_wedding` (`id_paket`, `nama_paket`, `harga`) VALUES
(1, 'Paket Bismillah Lancar', 15000000),
(2, 'Paket Gas Nikah', 25000000),
(3, 'Paket Akhirnya Sah', 40000000),
(4, 'Paket Cinta Sampai Tua', 55000000),
(5, 'Paket Lancar Sampai Hari H', 75000000);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` int NOT NULL,
  `nama` varchar(100) NOT NULL,
  `no_hp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama`, `no_hp`) VALUES
(1, 'Putri Anggita', '081333637409'),
(2, 'Vidya Khansa', '082211117197');

-- --------------------------------------------------------

--
-- Table structure for table `pemesanan_wedding`
--

CREATE TABLE `pemesanan_wedding` (
  `id_booking` int NOT NULL,
  `id_pelanggan` int NOT NULL,
  `id_paket` int NOT NULL,
  `venue` varchar(150) NOT NULL,
  `tanggal_acara` date NOT NULL,
  `pax` int NOT NULL
) ;

--
-- Dumping data for table `pemesanan_wedding`
--

INSERT INTO `pemesanan_wedding` (`id_booking`, `id_pelanggan`, `id_paket`, `venue`, `tanggal_acara`, `pax`) VALUES
(1, 1, 2, 'Taman Samarendah', '2026-09-01', 200);

-- --------------------------------------------------------

--
-- Table structure for table `vendor`
--

CREATE TABLE `vendor` (
  `id_vendor` int NOT NULL,
  `nama_vendor` varchar(100) NOT NULL,
  `no_telepon` varchar(20) NOT NULL,
  `jenis_vendor` enum('Catering','Dekorasi') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `vendor`
--

INSERT INTO `vendor` (`id_vendor`, `nama_vendor`, `no_telepon`, `jenis_vendor`) VALUES
(1, 'Sundari Catering', '081283619319', 'Catering'),
(2, 'Glam Your Eyes', '081233691333', 'Dekorasi'),
(3, 'Sour Sally', '08122334455', 'Catering'),
(4, 'Dekor Bu Agus', '081234321', 'Dekorasi');

-- --------------------------------------------------------

--
-- Table structure for table `vendor_catering`
--

CREATE TABLE `vendor_catering` (
  `id_vendor` int NOT NULL,
  `jenis_masakan` varchar(100) NOT NULL,
  `sistem_penyajian` varchar(100) NOT NULL,
  `harga_per_pax` int NOT NULL
) ;

--
-- Dumping data for table `vendor_catering`
--

INSERT INTO `vendor_catering` (`id_vendor`, `jenis_masakan`, `sistem_penyajian`, `harga_per_pax`) VALUES
(1, 'Nusantara', 'Prasmanan', 75000),
(3, 'Es Krim', 'Tenant', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `vendor_dekorasi`
--

CREATE TABLE `vendor_dekorasi` (
  `id_vendor` int NOT NULL,
  `tema_dekorasi` varchar(100) NOT NULL,
  `jenis_dekorasi` varchar(100) NOT NULL,
  `harga_paket_dekorasi` int NOT NULL
) ;

--
-- Dumping data for table `vendor_dekorasi`
--

INSERT INTO `vendor_dekorasi` (`id_vendor`, `tema_dekorasi`, `jenis_dekorasi`, `harga_paket_dekorasi`) VALUES
(2, 'Rose Garden', 'Outdoor', 8700000),
(4, 'Pink Castle', 'Indoor', 25000000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `paket_wedding`
--
ALTER TABLE `paket_wedding`
  ADD PRIMARY KEY (`id_paket`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `pemesanan_wedding`
--
ALTER TABLE `pemesanan_wedding`
  ADD PRIMARY KEY (`id_booking`),
  ADD KEY `fk_pesan_pelanggan` (`id_pelanggan`),
  ADD KEY `fk_pesan_paket` (`id_paket`);

--
-- Indexes for table `vendor`
--
ALTER TABLE `vendor`
  ADD PRIMARY KEY (`id_vendor`);

--
-- Indexes for table `vendor_catering`
--
ALTER TABLE `vendor_catering`
  ADD PRIMARY KEY (`id_vendor`);

--
-- Indexes for table `vendor_dekorasi`
--
ALTER TABLE `vendor_dekorasi`
  ADD PRIMARY KEY (`id_vendor`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pemesanan_wedding`
--
ALTER TABLE `pemesanan_wedding`
  ADD CONSTRAINT `fk_pesan_paket` FOREIGN KEY (`id_paket`) REFERENCES `paket_wedding` (`id_paket`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_pesan_pelanggan` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Constraints for table `vendor_catering`
--
ALTER TABLE `vendor_catering`
  ADD CONSTRAINT `fk_catering_vendor` FOREIGN KEY (`id_vendor`) REFERENCES `vendor` (`id_vendor`) ON DELETE CASCADE;

--
-- Constraints for table `vendor_dekorasi`
--
ALTER TABLE `vendor_dekorasi`
  ADD CONSTRAINT `fk_dekorasi_vendor` FOREIGN KEY (`id_vendor`) REFERENCES `vendor` (`id_vendor`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
