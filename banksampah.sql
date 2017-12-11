-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 08, 2017 at 10:02 AM
-- Server version: 5.5.55-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `banksampah`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `user_name` varchar(20) NOT NULL,
  `password` varchar(64) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`user_name`, `password`, `status`) VALUES
('admin', '21232f297a57a5a743894a0e4a801fc3', 0);

-- --------------------------------------------------------

--
-- Table structure for table `administrasi`
--

CREATE TABLE IF NOT EXISTS `administrasi` (
  `id_adm` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `saldo` double NOT NULL DEFAULT '0',
  `keterangan` varchar(64) NOT NULL,
  `pemasukan` double NOT NULL,
  PRIMARY KEY (`id_adm`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=47 ;

--
-- Dumping data for table `administrasi`
--

INSERT INTO `administrasi` (`id_adm`, `tanggal`, `saldo`, `keterangan`, `pemasukan`) VALUES
(15, '2017-11-24 13:10:25', 10000000, 'Modal Awal', 10000000),
(40, '2017-12-07 14:21:50', 10600000, 'Penjualan Sampah', 600000),
(41, '2017-12-07 14:23:02', 10780000, 'Penjualan Sampah', 180000),
(42, '2017-12-07 14:23:46', 13480000, 'Penjualan Sampah', 2700000),
(43, '2017-12-07 14:28:07', 13380000, 'Penarikan Saldo Member', -100000),
(44, '2017-12-07 15:50:29', 13280000, 'Penarikan Saldo Member', -100000),
(45, '2017-12-07 15:52:50', 13880000, 'Penjualan Sampah', 600000),
(46, '2017-12-07 15:53:31', 13380000, 'Penarikan Saldo Member', -500000);

--
-- Triggers `administrasi`
--
DROP TRIGGER IF EXISTS `adm_before_insert`;
DELIMITER //
CREATE TRIGGER `adm_before_insert` BEFORE INSERT ON `administrasi`
 FOR EACH ROW BEGIN

   DECLARE cur double;
	SELECT saldo FROM administrasi ORDER BY id_adm DESC LIMIT 1 INTO cur;
   	SET NEW.saldo = NEW.pemasukan + cur;

END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `id_member` int(11) NOT NULL AUTO_INCREMENT,
  `nik` varchar(20) NOT NULL,
  `nama` varchar(35) NOT NULL,
  `alamat` text NOT NULL,
  `no_telp` varchar(15) NOT NULL,
  `saldo` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_member`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id_member`, `nik`, `nama`, `alamat`, `no_telp`, `saldo`) VALUES
(2, '19981868276', 'Ahmad Riza', 'Joyo Sari No. 50', '088166144256', 125000),
(4, '77188117', 'Tegar A', 'Joyosari 50', '0881615511', 800000),
(5, '199191771', 'Damar', 'Jauh', '0818661551', 0),
(6, '1889272781', 'Tony Stark', 'New York', '085661771621', 160000),
(7, '19919211181', 'Bruce Wayne', 'Gotham City', '085177188161', 250000),
(8, '881918182821', 'Peter Parker', 'New York', '085661771818', 117000),
(9, '116661771', 'Bakir', 'Jauh', '085616177251', 0);

-- --------------------------------------------------------

--
-- Table structure for table `pengepul`
--

CREATE TABLE IF NOT EXISTS `pengepul` (
  `id_pengepul` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(20) NOT NULL,
  `alamat` text NOT NULL,
  `jadwal` varchar(64) NOT NULL,
  `no_telp` varchar(15) NOT NULL,
  PRIMARY KEY (`id_pengepul`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `pengepul`
--

INSERT INTO `pengepul` (`id_pengepul`, `nama`, `alamat`, `jadwal`, `no_telp`) VALUES
(1, 'Haji Somad', 'Radiator Springs', 'Minggu ke 2 hari senin', '0866254132'),
(5, 'Wak Kaji Soleh', 'Radiator Springs', 'Jumat Pagi ', '08819171881'),
(6, 'Pak pengepul', 'Jauh', 'Jumat ke 2', '06616166261');

-- --------------------------------------------------------

--
-- Table structure for table `sampah`
--

CREATE TABLE IF NOT EXISTS `sampah` (
  `id_jenis` int(11) NOT NULL AUTO_INCREMENT,
  `jenis` varchar(20) NOT NULL,
  `harga_jual` double NOT NULL,
  `harga_beli` double NOT NULL,
  `stok` int(11) NOT NULL,
  PRIMARY KEY (`id_jenis`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `sampah`
--

INSERT INTO `sampah` (`id_jenis`, `jenis`, `harga_jual`, `harga_beli`, `stok`) VALUES
(1, 'Plastik', 6000, 5000, 13),
(3, 'Tembaga', 30000, 25000, 5),
(4, 'Kertas', 1200, 1000, 4),
(5, 'Botol Aqua', 4000, 3000, 2),
(6, 'Seng', 1300, 1000, 4),
(7, 'Kardus', 1000, 700, 5),
(8, 'Besi Tebal', 3000, 2500, 10),
(9, 'Besi Tipis', 2000, 1500, 5);

-- --------------------------------------------------------

--
-- Table structure for table `tarik_tunai`
--

CREATE TABLE IF NOT EXISTS `tarik_tunai` (
  `id_penarikan` int(11) NOT NULL AUTO_INCREMENT,
  `id_member` int(11) NOT NULL,
  `nominal` double NOT NULL,
  `tgl` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_penarikan`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `tarik_tunai`
--

INSERT INTO `tarik_tunai` (`id_penarikan`, `id_member`, `nominal`, `tgl`) VALUES
(1, 2, 100000, '2017-12-07 14:28:07'),
(2, 6, 100000, '2017-12-07 15:50:29'),
(3, 9, 500000, '2017-12-07 15:53:31');

--
-- Triggers `tarik_tunai`
--
DROP TRIGGER IF EXISTS `tarik_tunai_a_insert`;
DELIMITER //
CREATE TRIGGER `tarik_tunai_a_insert` AFTER INSERT ON `tarik_tunai`
 FOR EACH ROW BEGIN

	DECLARE cur double;
	DECLARE totalan double;

	SELECT saldo FROM member WHERE id_member = NEW.id_member INTO cur;	
	
	SET cur = cur - NEW.nominal;
	
	SET totalan = NEW.nominal * -1;

	INSERT INTO administrasi VALUES (default,default,default,"Penarikan Saldo Member", totalan);

	UPDATE member SET saldo = cur WHERE id_member = NEW.id_member; 
  
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_beli`
--

CREATE TABLE IF NOT EXISTS `transaksi_beli` (
  `id_tbeli` int(11) NOT NULL AUTO_INCREMENT,
  `id_jenis` int(11) NOT NULL,
  `berat_total` int(11) NOT NULL,
  `nomor_nota` varchar(20) NOT NULL,
  `id_member` int(11) NOT NULL,
  `total` double NOT NULL DEFAULT '0',
  `tanggal` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_tbeli`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `transaksi_beli`
--

INSERT INTO `transaksi_beli` (`id_tbeli`, `id_jenis`, `berat_total`, `nomor_nota`, `id_member`, `total`, `tanggal`) VALUES
(1, 1, 50, '20171207134211', 7, 250000, '2017-12-07 13:42:11'),
(2, 2, 10, '20171207140137', 2, 100000, '2017-12-07 14:01:37'),
(3, 4, 9, '20171207140356', 8, 117000, '2017-12-07 14:03:56'),
(4, 4, 10, '20171207140507', 6, 130000, '2017-12-07 14:05:07'),
(5, 3, 5, '20171207130507', 2, 125000, '2017-12-07 14:09:18'),
(6, 4, 10, '20171207141053', 6, 130000, '2017-12-07 14:10:53'),
(7, 2, 80, '20171207141407', 4, 800000, '2017-12-07 14:14:07'),
(8, 1, 100, '20171207155128', 9, 500000, '2017-12-07 15:51:28');

--
-- Triggers `transaksi_beli`
--
DROP TRIGGER IF EXISTS `beli_after_insert`;
DELIMITER //
CREATE TRIGGER `beli_after_insert` AFTER INSERT ON `transaksi_beli`
 FOR EACH ROW BEGIN

	DECLARE cur integer;
	DECLARE saldomember integer;
	
	SELECT stok FROM sampah WHERE id_jenis = NEW.id_jenis INTO cur;	
	
	SET cur = cur + NEW.berat_total;

	UPDATE sampah SET stok = cur WHERE id_jenis = NEW.id_jenis; 

	SELECT saldo FROM member WHERE id_member = NEW.id_member INTO saldomember;
	SET saldomember = saldomember + NEW.total;
	UPDATE member set saldo = saldomember WHERE id_member = NEW.id_member;

  
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `beli_before_insert`;
DELIMITER //
CREATE TRIGGER `beli_before_insert` BEFORE INSERT ON `transaksi_beli`
 FOR EACH ROW BEGIN 
DECLARE harga DOUBLE;

SELECT harga_beli
FROM sampah
WHERE id_jenis = NEW.id_jenis
INTO harga;

SET NEW.total = harga * NEW.berat_total;

END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_jual`
--

CREATE TABLE IF NOT EXISTS `transaksi_jual` (
  `id_tjual` int(11) NOT NULL AUTO_INCREMENT,
  `nota` varchar(32) NOT NULL,
  `id_pengepul` int(11) NOT NULL,
  `id_jenis` int(11) NOT NULL,
  `berat_total` int(11) NOT NULL,
  `total` double NOT NULL DEFAULT '0',
  `tanggal` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_tjual`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `transaksi_jual`
--

INSERT INTO `transaksi_jual` (`id_tjual`, `nota`, `id_pengepul`, `id_jenis`, `berat_total`, `total`, `tanggal`) VALUES
(1, '20171207142150', 5, 3, 20, 600000, '2017-12-07 14:21:50'),
(2, '20171207142302', 1, 1, 30, 180000, '2017-12-07 14:23:02'),
(3, '20171207142346', 1, 3, 90, 2700000, '2017-12-07 14:23:46'),
(4, '20171207155250', 6, 1, 100, 600000, '2017-12-07 15:52:50');

--
-- Triggers `transaksi_jual`
--
DROP TRIGGER IF EXISTS `jual_after_insert`;
DELIMITER //
CREATE TRIGGER `jual_after_insert` AFTER INSERT ON `transaksi_jual`
 FOR EACH ROW BEGIN

	DECLARE cur integer;
	SELECT stok FROM sampah WHERE id_jenis = NEW.id_jenis INTO cur;	

	INSERT INTO administrasi VALUES (default,default,default,"Penjualan Sampah", NEW.total);
	
	SET cur = cur - NEW.berat_total;

	UPDATE sampah SET stok = cur WHERE id_jenis = NEW.id_jenis; 
  
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `jual_before_insert`;
DELIMITER //
CREATE TRIGGER `jual_before_insert` BEFORE INSERT ON `transaksi_jual`
 FOR EACH ROW BEGIN 
DECLARE harga DOUBLE;

SELECT harga_jual
FROM sampah
WHERE id_jenis = NEW.id_jenis
INTO harga;

SET NEW.total = harga * NEW.berat_total;

END
//
DELIMITER ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
